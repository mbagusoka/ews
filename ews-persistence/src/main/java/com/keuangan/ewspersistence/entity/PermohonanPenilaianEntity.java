package com.keuangan.ewspersistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "permohonan_penilaian")
public class PermohonanPenilaianEntity extends BaseEntity {

    @Column(name = "penilaian_id")
    private UUID penilaianId;

    @Column(name = "no_surat_tugas")
    private String noSuratTugas;

    @Column(name = "tanggal_surat_tugas")
    private String tanggalSuratTugas;

    @Column(name = "tanggal_mulai_survey")
    private String tanggalMulaiSurvey;

    @Column(name = "tanggal_selesai_survey")
    private String tanggalSelesaiSurvey;

    @Column(name = "tanggal_selesai")
    private String tanggalSelesai;

    public UUID getPenilaianId() {
        return penilaianId;
    }

    public void setPenilaianId(UUID penilaianId) {
        this.penilaianId = penilaianId;
    }

    public String getNoSuratTugas() {
        return noSuratTugas;
    }

    public void setNoSuratTugas(String noSuratTugas) {
        this.noSuratTugas = noSuratTugas;
    }

    public String getTanggalSuratTugas() {
        return tanggalSuratTugas;
    }

    public void setTanggalSuratTugas(String tanggalSuratTugas) {
        this.tanggalSuratTugas = tanggalSuratTugas;
    }

    public String getTanggalMulaiSurvey() {
        return tanggalMulaiSurvey;
    }

    public void setTanggalMulaiSurvey(String tanggalMulaiSurvey) {
        this.tanggalMulaiSurvey = tanggalMulaiSurvey;
    }

    public String getTanggalSelesaiSurvey() {
        return tanggalSelesaiSurvey;
    }

    public void setTanggalSelesaiSurvey(String tanggalSelesaiSurvey) {
        this.tanggalSelesaiSurvey = tanggalSelesaiSurvey;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }
}
