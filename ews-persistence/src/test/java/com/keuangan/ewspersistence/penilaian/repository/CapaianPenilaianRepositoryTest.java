package com.keuangan.ewspersistence.penilaian.repository;

import com.keuangan.ewspersistence.commmon.CapaianEnum;
import com.keuangan.ewspersistence.entity.CapaianPenilaianEntity;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.config.H2JpaConfig;
import com.keuangan.ewspersistence.repository.CapaianPenilaianRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.UUID;

import static com.google.common.truth.Truth.assertThat;

@SpringBootTest(classes = H2JpaConfig.class)
@Transactional
class CapaianPenilaianRepositoryTest {

    private static final String DATE_DUMMY = "01-01-2019";

    @Autowired private CapaianPenilaianRepository capaianPenilaianRepository;

    @BeforeEach
    void setUp() {
        CapaianPenilaianEntity entity = constructCapaianPenilaianEntityDummy();
        capaianPenilaianRepository.save(entity);
    }

    @AfterEach
    void cleanUp() {
        capaianPenilaianRepository.deleteAll();
    }

    @Test
    void saveTest() {
        assertThat(capaianPenilaianRepository.count()).isEqualTo(1);
    }

    @Test
    void whenSaveCapaianPenilaian_thenAutomaticallySetCreatedDate() {
        CapaianPenilaianEntity capaianPenilaianEntity = capaianPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(capaianPenilaianEntity.getCreatedDate()).isNotNull();
    }

    @Test
    void whenSaveCapaianPenilaian_thenAutomaticallySetIsDelete() {
        CapaianPenilaianEntity capaianPenilaianEntity = capaianPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(capaianPenilaianEntity.isDelete()).isFalse();
    }

    @Test
    void whenUpdateCapaianPenilaian_thenAutomaticallySetUpdatedDate() {
        CapaianPenilaianEntity capaianPenilaianEntity = capaianPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        capaianPenilaianEntity.setCapaian(CapaianEnum.POOR.getDescription());
        capaianPenilaianRepository.saveAndFlush(capaianPenilaianEntity);
        CapaianPenilaianEntity capaianPenilaianUpdated = capaianPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(capaianPenilaianUpdated.getUpdatedDate()).isNotNull();
    }

    private CapaianPenilaianEntity constructCapaianPenilaianEntityDummy() {
        CapaianPenilaianEntity capaianPenilaianEntity = new CapaianPenilaianEntity();
        capaianPenilaianEntity.setId(TestConstant.UUID_DUMMY);
        capaianPenilaianEntity.setPenilaianId(UUID.randomUUID());
        String capaian = CapaianEnum.getCapaianDescription(5);
        capaianPenilaianEntity.setCapaian(capaian);
        capaianPenilaianEntity.setRealisasi(DATE_DUMMY);
        return capaianPenilaianEntity;
    }
}
