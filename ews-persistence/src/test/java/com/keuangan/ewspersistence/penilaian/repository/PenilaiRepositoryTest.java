package com.keuangan.ewspersistence.penilaian.repository;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.common.TestUtils;
import com.keuangan.ewspersistence.penilaian.config.H2JpaConfig;
import com.keuangan.ewspersistence.repository.PenilaiRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(classes = H2JpaConfig.class)
@Transactional
class PenilaiRepositoryTest {

    @Autowired private PenilaiRepository penilaiRepository;

    @BeforeEach
    void setUp() {
        PenilaiEntity entity = TestUtils.constructPenilaiDummyOne();
        penilaiRepository.save(entity);
    }

    @AfterEach
    void cleanUp() {
        penilaiRepository.deleteAll();
    }

    @Test
    void saveTest() {
        assertThat(penilaiRepository.count()).isEqualTo(1);
    }

    @Test
    void whenSavePenilai_thenAutomaticallySetCreatedDate() {
        PenilaiEntity penilaiEntity = penilaiRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaiEntity.getCreatedDate()).isNotNull();
    }

    @Test
    void whenSavePneilai_thenAutomaticallySetIsDelete() {
        PenilaiEntity penilaiEntity = penilaiRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaiEntity.isDelete()).isFalse();
    }

    @Test
    void whenUpdatePenilai_thenAutomaticallySetUpdatedDate() {
        PenilaiEntity penilaiEntity = penilaiRepository.getOne(TestConstant.UUID_DUMMY);
        penilaiEntity.setEmail(TestConstant.DUMMY_2);
        penilaiRepository.saveAndFlush(penilaiEntity);
        PenilaiEntity penilaiUpdated =  penilaiRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaiUpdated.getUpdatedDate()).isNotNull();
    }
}
