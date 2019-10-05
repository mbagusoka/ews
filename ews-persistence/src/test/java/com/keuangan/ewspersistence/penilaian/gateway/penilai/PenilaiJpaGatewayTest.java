package com.keuangan.ewspersistence.penilaian.gateway.penilai;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.gateway.PenilaiGateway;
import com.keuangan.ewspersistence.gateway.filter.PenilaiFilter;
import com.keuangan.ewspersistence.gateway.impl.PenilaiJpaGateway;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.common.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;

class PenilaiJpaGatewayTest {

    private PenilaiRepositorySpy repositorySpy;
    private PenilaiGateway gateway;
    private PenilaiFilter filter;

    @BeforeEach
    void setUp() {
        repositorySpy = new PenilaiRepositorySpy();
        gateway = new PenilaiJpaGateway(repositorySpy);
        filter = new PenilaiFilter();
    }

    @Test
    void givenNonEmptyFromDatabase_whenFindPenilai_shouldReturnNonEmptyData() {
        PenilaiEntity penilaiEntity = TestUtils.constructPenilaiDummyOne();
        repositorySpy.penilaiOptional = Optional.of(penilaiEntity);
        Optional<PenilaiEntity> penilaiOptional = gateway.findById(TestConstant.UUID_DUMMY);
        assertThat(penilaiEntity).isNotNull();
        penilaiOptional.ifPresent(penilai -> assertThat(penilai.getId()).isEqualTo(TestConstant.UUID_DUMMY));
    }

    @Test
    void whenListingPenilai_shouldCallFindPenilaiByFilterInRepository() {
        injectEmptyRepository();
        gateway.findPenilaiByFilter(filter);
        assertThat(repositorySpy.penilaiByFilterWasCalled).isTrue();
    }

    @Test
    void givenEmptyResultFromDatabase_whenListingPenilai_shouldReturnEmptyList() {
        injectEmptyRepository();
        Page<PenilaiEntity> penilaiEntityPage = gateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getContent()).isEmpty();
    }

    @Test
    void givenNonEmptyResultFromDatabase_whenListingPenilai_shouldReturnNonEmptyList() {
        injectEntity();
        Page<PenilaiEntity> penilaiEntityPage = gateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getContent()).isNotEmpty();
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(1);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(1);
    }

    @Test
    void givenNonEmptyFilter_whenListingPenilai_shouldCallRepositoryWithSpecification() {
        injectEmptyRepositoryAndGateway();
        assertThat(repositorySpy.specification).isNotNull();
        assertThat(repositorySpy.specification).isInstanceOf(Specification.class);
    }

    @Test
    void givenNonEmptyFilter_whenListingPenilai_shouldCallRepositoryWithPageable() {
        injectEmptyRepositoryAndGateway();
        assertThat(repositorySpy.pageable).isNotNull();
        assertThat(repositorySpy.pageable).isInstanceOf(Pageable.class);
    }

    private void injectEntity() {
        PenilaiEntity penilaiEntity = TestUtils.constructPenilaiDummyOne();
        repositorySpy.penilaiPage = new PageImpl<>(Collections.singletonList(penilaiEntity));
    }

    private void injectEmptyRepositoryAndGateway() {
        injectEmptyRepository();
        gateway.findPenilaiByFilter(filter);
    }

    private void injectEmptyRepository() {
        repositorySpy.penilaiPage = new PageImpl<>(Collections.emptyList());
    }
}
