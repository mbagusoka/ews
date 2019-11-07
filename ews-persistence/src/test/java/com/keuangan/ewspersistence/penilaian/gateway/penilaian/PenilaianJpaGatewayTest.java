package com.keuangan.ewspersistence.penilaian.gateway.penilaian;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
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

class PenilaianJpaGatewayTest {

    private PenilaianRepositorySpy repositorySpy;
    private PenilaianGateway gateway;
    private PenilaianFilter filter;

    @BeforeEach
    void setUp() {
        repositorySpy = new PenilaianRepositorySpy();
        gateway = new PenilaianJpaGateway(repositorySpy);
        filter = new PenilaianFilter();
    }

    @Test
    void givenNonEmptyFromDatabase_whenFindPenilaian_shouldReturnNonEmptyData() {
        PenilaianEntity penilaianEntity = TestUtils.constructPenilaianDummyOne();
        repositorySpy.penilaianOptional = Optional.of(penilaianEntity);
        Optional<PenilaianEntity> penilaianOptional = gateway.findById(TestConstant.UUID_DUMMY);
        assertThat(penilaianOptional).isNotNull();
        penilaianOptional.ifPresent(penilaian -> assertThat(penilaian.getId()).isEqualTo(TestConstant.UUID_DUMMY));
    }

    @Test
    void whenListingPenilaian_shouldCallFindPenilaianByFilterInRepository() {
        injectEmptyRepository();
        gateway.findPenilaianByFilter(filter);
        assertThat(repositorySpy.penilaianByFilterWasCalled).isTrue();
    }

    @Test
    void givenEmptyResultFromDatabase_whenListingPenilaian_shouldReturnEmptyList() {
        injectEmptyRepository();
        Page<PenilaianEntity> penilaianEntityPage = gateway.findPenilaianByFilter(filter);
        assertThat(penilaianEntityPage.getContent()).isEmpty();
    }

    @Test
    void givenNonEmptyResultFromDatabase_whenListingPenilaian_shouldReturnNonEmptyList() {
        injectEntity();
        Page<PenilaianEntity> penilaianPage = gateway.findPenilaianByFilter(filter);
        assertThat(penilaianPage.getContent()).isNotEmpty();
        assertThat(penilaianPage.getTotalPages()).isEqualTo(1);
        assertThat(penilaianPage.getTotalElements()).isEqualTo(1);
    }

    @Test
    void givenNonEmptyFilter_whenListingPenilaian_shouldCallRepositoryWithSpecification() {
        injectEmptyRepositoryAndGateway();
        assertThat(repositorySpy.specification).isNotNull();
        assertThat(repositorySpy.specification).isInstanceOf(Specification.class);
    }

    @Test
    void givenNonEmptyFilter_whenListingPenilaian_shouldConstructRepositoryWithPageable() {
        injectEmptyRepositoryAndGateway();
        assertThat(repositorySpy.pageable).isNotNull();
        assertThat(repositorySpy.pageable).isInstanceOf(Pageable.class);
    }

    private void injectEntity() {
        PenilaianEntity penilaianEntity = TestUtils.constructPenilaianDummyOne();
        repositorySpy.penilaianPage = new PageImpl<>(Collections.singletonList(penilaianEntity));
    }

    private void injectEmptyRepositoryAndGateway() {
        injectEmptyRepository();
        gateway.findPenilaianByFilter(filter);
    }

    private void injectEmptyRepository() {
        repositorySpy.penilaianPage = new PageImpl<>(Collections.emptyList());
    }
}
