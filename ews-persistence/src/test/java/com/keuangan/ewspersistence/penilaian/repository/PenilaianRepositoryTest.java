package com.keuangan.ewspersistence.penilaian.repository;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.config.H2JpaConfig;
import com.keuangan.ewspersistence.repository.PenilaianRepository;
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
class PenilaianRepositoryTest {

    @Autowired private PenilaianRepository penilaianRepository;

    @BeforeEach
    void setUp() {
        PenilaianEntity entity = constructPenilaianDummy();
        penilaianRepository.save(entity);
    }

    @AfterEach
    void cleanUp() {
        penilaianRepository.deleteAll();
    }

    @Test
    void saveTest() {
        assertThat(penilaianRepository.count()).isEqualTo(1);
    }

    @Test
    void whenSavePenilaian_thenAutomaticallySetCreatedDate() {
        PenilaianEntity penilaianEntity = penilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaianEntity.getCreatedDate()).isNotNull();
    }

    @Test
    void whenSavePenilaian_thenAutomaticallySetIsDelete() {
        PenilaianEntity penilaianEntity = penilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaianEntity.isDelete()).isFalse();
    }

    @Test
    void whenUpdatePenilaian_thenAutomaticallySetUpdatedDate() {
        PenilaianEntity penilaianEntity = penilaianRepository.getOne(TestConstant.UUID_DUMMY);
        penilaianEntity.setDeskripsiObjek(TestConstant.DUMMY_2);
        penilaianRepository.saveAndFlush(penilaianEntity);
        PenilaianEntity penilaianUpdated = penilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(penilaianUpdated.getUpdatedDate()).isNotNull();
    }

    private PenilaianEntity constructPenilaianDummy() {
        PenilaianEntity penilaian = new PenilaianEntity();
        penilaian.setId(TestConstant.UUID_DUMMY);
        penilaian.setNoSuratPermohonan(TestConstant.DUMMY);
        penilaian.setTanggalPenilaian(TestConstant.DUMMY);
        penilaian.setTanggalDisposisi(TestConstant.DUMMY);
        penilaian.setDeskripsiObjek(TestConstant.DUMMY);
        penilaian.setSatker(TestConstant.DUMMY);
        penilaian.setKl(TestConstant.DUMMY);
        penilaian.setVerifikator(TestConstant.DUMMY);
        penilaian.setStatusId(UUID.randomUUID());
        penilaian.setJenisPenilaianId(UUID.randomUUID());
        return penilaian;
    }
}
