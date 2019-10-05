package com.keuangan.ewspersistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "capaian_penilaian")
public class CapaianPenilaianEntity extends BaseEntity {

    @Column(name = "penilaian_id")
    private UUID penilaianId;

    @Column(name = "realisasi")
    private String realisasi;

    @Column(name = "capaian")
    private String capaian;

    @Column(name = "jenis")
    private String jenis;

    public UUID getPenilaianId() {
        return penilaianId;
    }

    public void setPenilaianId(UUID penilaianId) {
        this.penilaianId = penilaianId;
    }

    public String getRealisasi() {
        return realisasi;
    }

    public void setRealisasi(String realisasi) {
        this.realisasi = realisasi;
    }

    public String getCapaian() {
        return capaian;
    }

    public void setCapaian(String capaian) {
        this.capaian = capaian;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
