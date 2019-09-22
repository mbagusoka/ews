package com.keuangan.ewspersistence.repository;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PenilaianRepository extends JpaRepository<PenilaianEntity, UUID> {
}
