package com.keuangan.ewspersistence.penilaian.repository;

import com.keuangan.ewspersistence.entity.PermohonanPenilaianEntity;
import com.keuangan.ewspersistence.penilaian.common.TestConstant;
import com.keuangan.ewspersistence.penilaian.config.H2JpaConfig;
import com.keuangan.ewspersistence.repository.PermohonanPenilaianRepository;
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
class PermohonanPenilaianTest {

    @Autowired private PermohonanPenilaianRepository permohonanPenilaianRepository;

    @BeforeEach
    void setUp() {
        PermohonanPenilaianEntity entity = constructPermohonanPenilaianDummy();
        permohonanPenilaianRepository.save(entity);
    }

    @AfterEach
    void cleanUp() {
        permohonanPenilaianRepository.deleteAll();
    }

    @Test
    void saveTest() {
        assertThat(permohonanPenilaianRepository.count()).isEqualTo(1);
    }

    @Test
    void whenSavePermohonanPenilaian_thenAutomaticallySetCreatedDate() {
        PermohonanPenilaianEntity permohonanPenilaianEntity = permohonanPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(permohonanPenilaianEntity.getCreatedDate()).isNotNull();
    }

    @Test
    void whenSavePermohonanPenilaian_thenAutomaticallySetIsDelete() {
        PermohonanPenilaianEntity permohonanPenilaianEntity = permohonanPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(permohonanPenilaianEntity.isDelete()).isFalse();
    }

    @Test
    void whenUpdatePermohonanPenilaian_thenAutomaticallySetUpdatedDate() {
        PermohonanPenilaianEntity permohonanPenilaianEntity = permohonanPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        permohonanPenilaianEntity.setNoSuratTugas(TestConstant.DUMMY_2);
        permohonanPenilaianRepository.saveAndFlush(permohonanPenilaianEntity);
        PermohonanPenilaianEntity permohonanPenilaianUpdated = permohonanPenilaianRepository.getOne(TestConstant.UUID_DUMMY);
        assertThat(permohonanPenilaianUpdated.getUpdatedDate()).isNotNull();
    }

    private PermohonanPenilaianEntity constructPermohonanPenilaianDummy() {
        PermohonanPenilaianEntity permohonanPenilaian = new PermohonanPenilaianEntity();
        permohonanPenilaian.setId(TestConstant.UUID_DUMMY);
        permohonanPenilaian.setPenilaianId(UUID.randomUUID());
        permohonanPenilaian.setNoSuratTugas(TestConstant.DUMMY);
        permohonanPenilaian.setTanggalSuratTugas(TestConstant.DUMMY);
        permohonanPenilaian.setTanggalMulaiSurvey(TestConstant.DUMMY);
        permohonanPenilaian.setTanggalSelesaiSurvey(TestConstant.DUMMY);
        permohonanPenilaian.setTanggalSelesai(TestConstant.DUMMY);
        return permohonanPenilaian;
    }
}
