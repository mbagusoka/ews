package com.keuangan.ewspersistence.penilaian.common;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.entity.PenilaianEntity;

import java.util.Arrays;
import java.util.List;

public final class TestUtils {

    private TestUtils() {}

    public static PenilaiEntity constructPenilaiDummyOne() {
        PenilaiEntity penilaiEntity = new PenilaiEntity();
        penilaiEntity.setId(TestConstant.UUID_DUMMY);
        penilaiEntity.setName(TestConstant.DUMMY);
        penilaiEntity.setNip(TestConstant.DUMMY);
        penilaiEntity.setSeksi(TestConstant.DUMMY);
        penilaiEntity.setEmail(TestConstant.DUMMY);
        return penilaiEntity;
    }

    private static PenilaiEntity constructPenilaiDummyTwo() {
        PenilaiEntity penilaiEntity = new PenilaiEntity();
        penilaiEntity.setId(TestConstant.UUID_DUMMY_2);
        penilaiEntity.setName(TestConstant.DUMMY_2);
        penilaiEntity.setNip(TestConstant.DUMMY_2);
        penilaiEntity.setSeksi(TestConstant.DUMMY_2);
        penilaiEntity.setEmail(TestConstant.DUMMY_2);
        return penilaiEntity;
    }

    public static List<PenilaiEntity> constructPenilaiDummiesList() {
        return Arrays.asList(constructPenilaiDummyOne(), constructPenilaiDummyTwo());
    }

    public static PenilaianEntity constructPenilaianDummyOne() {
        PenilaianEntity penilaian = new PenilaianEntity();
        penilaian.setId(TestConstant.UUID_DUMMY);
        penilaian.setNoSuratPermohonan(TestConstant.DUMMY);
        penilaian.setTanggalPenilaian(TestConstant.DUMMY);
        penilaian.setTanggalDisposisi(TestConstant.DUMMY);
        penilaian.setDeskripsiObjek(TestConstant.DUMMY);
        penilaian.setSatker(TestConstant.DUMMY);
        penilaian.setKl(TestConstant.DUMMY);
        penilaian.setVerifikator(TestConstant.DUMMY);
        penilaian.setStatus(TestConstant.DUMMY);
        penilaian.setJenisPenilaian(TestConstant.DUMMY);
        return penilaian;
    }

    private static PenilaianEntity constructPenilaianDummyTwo() {
        PenilaianEntity penilaian = new PenilaianEntity();
        penilaian.setId(TestConstant.UUID_DUMMY_2);
        penilaian.setNoSuratPermohonan(TestConstant.DUMMY_2);
        penilaian.setTanggalPenilaian(TestConstant.DUMMY_2);
        penilaian.setTanggalDisposisi(TestConstant.DUMMY_2);
        penilaian.setDeskripsiObjek(TestConstant.DUMMY_2);
        penilaian.setSatker(TestConstant.DUMMY_2);
        penilaian.setKl(TestConstant.DUMMY_2);
        penilaian.setVerifikator(TestConstant.DUMMY_2);
        penilaian.setStatus(TestConstant.DUMMY);
        penilaian.setJenisPenilaian(TestConstant.DUMMY);
        return penilaian;
    }
}
