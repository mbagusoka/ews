package com.keuangan.ewspersistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

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

    @Column(name = "status_id")
    private UUID statusId;

    @Column(name = "jenis_penilaian_id")
    private UUID jenisPenilaianId;

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

    public UUID getStatusId() {
        return statusId;
    }

    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }

    public UUID getJenisPenilaianId() {
        return jenisPenilaianId;
    }

    public void setJenisPenilaianId(UUID jenisPenilaianId) {
        this.jenisPenilaianId = jenisPenilaianId;
    }
}
