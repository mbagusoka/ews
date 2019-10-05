package com.keuangan.ewspersistence.commmon;

public enum JenisPenilaian {

    PERMOHONAN  ("Permohonan"),
    SURVEY      ("Survey");

    private final String description;

    JenisPenilaian(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
