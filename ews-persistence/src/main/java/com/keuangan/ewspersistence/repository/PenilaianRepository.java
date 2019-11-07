package com.keuangan.ewspersistence.repository;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PenilaianRepository extends JpaRepository<PenilaianEntity, UUID> {

    Page<PenilaianEntity> findAll(Specification specification, Pageable pageable);
}
