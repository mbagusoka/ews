package com.keuangan.ewspersistence.penilaian.gateway.penilaian;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PenilaianGateway {

    Optional<PenilaianEntity> findById(UUID id);

    Page<PenilaianEntity> findPenilaianByFilter(PenilaianFilter filter);
}
