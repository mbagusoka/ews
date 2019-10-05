package com.keuangan.ewspersistence.gateway;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.gateway.filter.PenilaiFilter;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PenilaiGateway {

    Optional<PenilaiEntity> findById(UUID id);

    Page<PenilaiEntity> findPenilaiByFilter(PenilaiFilter filter);
}
