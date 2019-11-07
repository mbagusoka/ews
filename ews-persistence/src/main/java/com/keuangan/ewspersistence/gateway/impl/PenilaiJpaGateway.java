package com.keuangan.ewspersistence.gateway.impl;

import com.keuangan.ewspersistence.commmon.PersistenceConstant;
import com.keuangan.ewspersistence.commmon.PersistenceUtils;
import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.gateway.PenilaiGateway;
import com.keuangan.ewspersistence.gateway.filter.PenilaiFilter;
import com.keuangan.ewspersistence.repository.PenilaiRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public class PenilaiJpaGateway implements PenilaiGateway {

    private PenilaiRepository penilaiRepository;

    public PenilaiJpaGateway(PenilaiRepository penilaiRepository) {
        this.penilaiRepository = penilaiRepository;
    }

    @Override
    public Optional<PenilaiEntity> findById(UUID id) {
        return penilaiRepository.findById(id);
    }

    @Override
    public Page<PenilaiEntity> findPenilaiByFilter(PenilaiFilter filter) {
        Specification<PenilaiEntity> specification = constructSpecification(filter);
        PageRequest pageRequest = PersistenceUtils.constructPageRequest(filter);
        Page<PenilaiEntity> penilaiEntityPage = penilaiRepository.findAll(specification, pageRequest);
        return null == penilaiEntityPage ? new PageImpl<>(Collections.emptyList()) : penilaiEntityPage;
    }

    private Specification<PenilaiEntity> constructSpecification(PenilaiFilter filter) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter.isNameValid()) {
                Predicate namePredicate = getPredicate(filter.getName(), PersistenceConstant.NAME, root, criteriaBuilder);
                predicates.add(namePredicate);
            }
            if (filter.isNipValid()) {
                Predicate nipPredicate = getPredicate(filter.getNip(), PersistenceConstant.NIP, root, criteriaBuilder);
                predicates.add(nipPredicate);
            }
            if (filter.isSeksiValid()) {
                Predicate seksiPredicate = getPredicate(filter.getSeksi(), PersistenceConstant.SEKSI, root, criteriaBuilder);
                predicates.add(seksiPredicate);
            }
            if (filter.isEmailValid()) {
                Predicate emailPredicate = getPredicate(filter.getEmail(), PersistenceConstant.EMAIL, root, criteriaBuilder);
                predicates.add(emailPredicate);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private Predicate getPredicate(String value, String param, Root<PenilaiEntity> root, CriteriaBuilder criteriaBuilder) {
        if (value.contains(PersistenceConstant.COMMA_SEPARATED)) {
            List<String> nameList = PersistenceUtils.stringToList(value, PersistenceConstant.COMMA_SEPARATED);
            return root.get(param).in(nameList);
        } else {
            String nameLike = PersistenceUtils.constructLike(value);
            return criteriaBuilder.like(root.get(PersistenceConstant.NAME), nameLike);
        }
    }
}
