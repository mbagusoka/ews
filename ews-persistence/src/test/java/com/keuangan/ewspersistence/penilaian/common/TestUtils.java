package com.keuangan.ewspersistence.penilaian.common;

import com.keuangan.ewspersistence.entity.PenilaiEntity;

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

    public static PenilaiEntity constructPenilaiDummyTwo() {
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
}
