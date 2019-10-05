package com.keuangan.ewspersistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "penilai")
public class PenilaiEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "nip")
    private String nip;

    @Column(name = "seksi")
    private String seksi;

    @Column(name = "email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getSeksi() {
        return seksi;
    }

    public void setSeksi(String seksi) {
        this.seksi = seksi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
