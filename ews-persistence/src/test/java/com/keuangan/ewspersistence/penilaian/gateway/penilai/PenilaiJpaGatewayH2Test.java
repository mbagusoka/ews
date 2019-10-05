package com.keuangan.ewspersistence.penilaian.gateway.penilai;

import com.keuangan.ewspersistence.commmon.PersistenceConstant;
import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.gateway.PenilaiGateway;
import com.keuangan.ewspersistence.gateway.filter.PenilaiFilter;
import com.keuangan.ewspersistence.gateway.impl.PenilaiJpaGateway;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.common.TestUtils;
import com.keuangan.ewspersistence.penilaian.config.H2JpaConfig;
import com.keuangan.ewspersistence.repository.PenilaiRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(classes = H2JpaConfig.class)
@Transactional
class PenilaiJpaGatewayH2Test {

    private static final String NOT_COMPLETED_VALUE = "mmy2";
    private static final String COMMA_SEPARATED_VALUE = "dummy,dummy2";

    @Autowired private PenilaiRepository penilaiRepository;
    private PenilaiGateway penilaiGateway;

    @BeforeEach
    void setUp() {
        penilaiGateway = new PenilaiJpaGateway(penilaiRepository);
    }

    @AfterEach
    void cleanUp() {
        penilaiRepository.deleteAll();
    }

    @Test
    void givenValidRequest_whenGettingPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        Optional<PenilaiEntity> penilaiOptional = penilaiGateway.findById(TestConstant.UUID_DUMMY);
        if (penilaiOptional.isPresent()) {
            PenilaiEntity penilaiEntity = penilaiOptional.get();
            assertThat(penilaiEntity.getId()).isEqualTo(TestConstant.UUID_DUMMY);
            assertThat(penilaiEntity.getName()).isEqualTo(TestConstant.DUMMY);
            assertThat(penilaiEntity.getNip()).isEqualTo(TestConstant.DUMMY);
            assertThat(penilaiEntity.getSeksi()).isEqualTo(TestConstant.DUMMY);
            assertThat(penilaiEntity.getEmail()).isEqualTo(TestConstant.DUMMY);
        } else {
            assert false;
        }
    }

    @Test
    void givenEmptyFilter_whenFindPenilai_shouldReturnAllEntities() {
        injectRepositoryWithDummies();
        Page<PenilaiEntity> penilaiEntityPage = penilaiGateway.findPenilaiByFilter(new PenilaiFilter());
        assertThat(penilaiEntityPage).isNotNull();
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(2);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(1);
    }

    @Test
    void givenNotCompletedNameFilter_whenFindPenilai_shouldReturnLikeQueryResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setName(NOT_COMPLETED_VALUE);
        assertLike(filter);
    }

    @Test
    void givenMultipleNameFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setName(COMMA_SEPARATED_VALUE);
        assertCommaSeparated(filter);
    }

    @Test
    void givenNotCompletedNipFilter_whenFindPenilai_shouldReturnLikeQueryResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setNip(NOT_COMPLETED_VALUE);
        assertLike(filter);
    }

    @Test
    void givenMultipleNipFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setNip(COMMA_SEPARATED_VALUE);
        assertCommaSeparated(filter);
    }

    @Test
    void givenNotCompletedSeksiFilter_whenFindPenilai_shouldReturnLikeQueryResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setSeksi(NOT_COMPLETED_VALUE);
        assertLike(filter);
    }

    @Test
    void givenMultipleSeksiFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setSeksi(COMMA_SEPARATED_VALUE);
        assertCommaSeparated(filter);
    }

    @Test
    void givenNotCompletedEmailFilter_whenFindPenilai_shouldReturnLikeQueryResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setEmail(NOT_COMPLETED_VALUE);
        assertLike(filter);
    }

    @Test
    void givenCommaSeparatedEmailFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setEmail(COMMA_SEPARATED_VALUE);
        assertCommaSeparated(filter);
    }

    @Test
    void givenSortingFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setSortBy(PersistenceConstant.NAME);
        filter.setSortingOrder(PersistenceConstant.DESC);
        Page<PenilaiEntity> penilaiEntityPage = penilaiGateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(1);
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(2);
        assertPenilaiOne(penilaiEntityPage.getContent().get(1));
        assertPenilaiTwo(penilaiEntityPage.getContent().get(0));
    }

    @Test
    void givenSortingAndPageFilter_whenFindPenilai_shouldReturnCorrectResult() {
        injectRepositoryWithDummies();
        PenilaiFilter filter = new PenilaiFilter();
        filter.setSortBy(PersistenceConstant.NAME);
        filter.setSortingOrder(PersistenceConstant.DESC);
        filter.setPageSize(1);
        Page<PenilaiEntity> penilaiEntityPage = penilaiGateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(2);
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(2);
        assertPenilaiTwo(penilaiEntityPage.getContent().get(0));
    }

    private void assertLike(PenilaiFilter filter) {
        Page<PenilaiEntity> penilaiEntityPage = penilaiGateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(1);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(1);
        assertPenilaiTwo(penilaiEntityPage.getContent().get(0));
    }

    private void assertCommaSeparated(PenilaiFilter filter) {
        Page<PenilaiEntity> penilaiEntityPage = penilaiGateway.findPenilaiByFilter(filter);
        assertThat(penilaiEntityPage.getTotalPages()).isEqualTo(1);
        assertThat(penilaiEntityPage.getTotalElements()).isEqualTo(2);
        assertPenilaiOne(penilaiEntityPage.getContent().get(0));
        assertPenilaiTwo(penilaiEntityPage.getContent().get(1));
    }

    private void assertPenilaiOne(PenilaiEntity penilaiEntity) {
        assertThat(penilaiEntity.getId()).isEqualTo(TestConstant.UUID_DUMMY);
        assertThat(penilaiEntity.getName()).isEqualTo(TestConstant.DUMMY);
        assertThat(penilaiEntity.getNip()).isEqualTo(TestConstant.DUMMY);
        assertThat(penilaiEntity.getSeksi()).isEqualTo(TestConstant.DUMMY);
        assertThat(penilaiEntity.getEmail()).isEqualTo(TestConstant.DUMMY);
    }

    private void assertPenilaiTwo(PenilaiEntity penilaiEntity) {
        assertThat(penilaiEntity.getId()).isEqualTo(TestConstant.UUID_DUMMY_2);
        assertThat(penilaiEntity.getName()).isEqualTo(TestConstant.DUMMY_2);
        assertThat(penilaiEntity.getNip()).isEqualTo(TestConstant.DUMMY_2);
        assertThat(penilaiEntity.getSeksi()).isEqualTo(TestConstant.DUMMY_2);
        assertThat(penilaiEntity.getEmail()).isEqualTo(TestConstant.DUMMY_2);
    }

    private void injectRepositoryWithDummies() {
        penilaiRepository.saveAll(TestUtils.constructPenilaiDummiesList());
    }
}
