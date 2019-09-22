package com.keuangan.ewspersistence.repository;

import com.keuangan.ewspersistence.entity.CapaianPenilaianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CapaianPenilaianRepository extends JpaRepository<CapaianPenilaianEntity, UUID> {
}
