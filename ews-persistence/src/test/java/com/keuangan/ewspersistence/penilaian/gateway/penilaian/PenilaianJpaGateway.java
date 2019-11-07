package com.keuangan.ewspersistence.penilaian.gateway.penilaian;

import com.keuangan.ewspersistence.commmon.PersistenceUtils;
import com.keuangan.ewspersistence.entity.PenilaianEntity;
import com.keuangan.ewspersistence.repository.PenilaianRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.*;

public class PenilaianJpaGateway implements PenilaianGateway {

    private PenilaianRepository penilaianRepository;

    public PenilaianJpaGateway(PenilaianRepository penilaianRepository) {
        this.penilaianRepository = penilaianRepository;
    }

    @Override
    public Optional<PenilaianEntity> findById(UUID id) {
        return penilaianRepository.findById(id);
    }

    @Override
    public Page<PenilaianEntity> findPenilaianByFilter(PenilaianFilter filter) {
        Specification<PenilaianEntity> specification = constructSpecification(filter);
        PageRequest pageRequest = PersistenceUtils.constructPageRequest(filter);
        Page<PenilaianEntity> penilaianPage = penilaianRepository.findAll(specification, pageRequest);
        return null == penilaianPage ? new PageImpl<>(Collections.emptyList()) : penilaianPage;
    }

    private Specification<PenilaianEntity> constructSpecification(PenilaianFilter filter) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
