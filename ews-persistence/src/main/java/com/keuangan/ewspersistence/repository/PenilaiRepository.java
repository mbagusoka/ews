package com.keuangan.ewspersistence.repository;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PenilaiRepository extends JpaRepository<PenilaiEntity, UUID> {

    Page<PenilaiEntity> findAll(Specification<PenilaiEntity> specification, Pageable pageable);
}
