package com.keuangan.ewspersistence.repository;

import com.keuangan.ewspersistence.entity.PermohonanPenilaianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermohonanPenilaianRepository extends JpaRepository<PermohonanPenilaianEntity, UUID> {
}
