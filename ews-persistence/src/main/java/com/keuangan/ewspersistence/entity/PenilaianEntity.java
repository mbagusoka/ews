package com.keuangan.ewspersistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "penilaian")
public class PenilaianEntity extends BaseEntity {

    @Column(name = "no_surat_permohonan")
    private String noSuratPermohonan;

    @Column(name = "tanggal_penilaian")
    private String tanggalPenilaian;

    @Column(name = "tanggal_disposisi")
    private String tanggalDisposisi;

    @Column(name = "deskripsi_objek")
    private String deskripsiObjek;

    @Column(name = "satker")
    private String satker;

    @Column(name = "kl")
    private String kl;

    @Column(name = "verifikator")
    private String verifikator;

    @Column(name = "status")
    private String status;

    @Column(name = "jenis_penilaian")
    private String jenisPenilaian;

    public String getNoSuratPermohonan() {
        return noSuratPermohonan;
    }

    public void setNoSuratPermohonan(String noSuratPermohonan) {
        this.noSuratPermohonan = noSuratPermohonan;
    }

    public String getTanggalPenilaian() {
        return tanggalPenilaian;
    }

    public void setTanggalPenilaian(String tanggalPenilaian) {
        this.tanggalPenilaian = tanggalPenilaian;
    }

    public String getTanggalDisposisi() {
        return tanggalDisposisi;
    }

    public void setTanggalDisposisi(String tanggalDisposisi) {
        this.tanggalDisposisi = tanggalDisposisi;
    }

    public String getDeskripsiObjek() {
        return deskripsiObjek;
    }

    public void setDeskripsiObjek(String deskripsiObjek) {
        this.deskripsiObjek = deskripsiObjek;
    }

    public String getSatker() {
        return satker;
    }

    public void setSatker(String satker) {
        this.satker = satker;
    }

    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl;
    }

    public String getVerifikator() {
        return verifikator;
    }

    public void setVerifikator(String verifikator) {
        this.verifikator = verifikator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenisPenilaian() {
        return jenisPenilaian;
    }

    public void setJenisPenilaian(String jenisPenilaian) {
        this.jenisPenilaian = jenisPenilaian;
    }
}
