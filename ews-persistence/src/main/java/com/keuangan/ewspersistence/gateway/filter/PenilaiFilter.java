package com.keuangan.ewspersistence.gateway.filter;

import com.keuangan.ewspersistence.commmon.PersistenceConstant;
import com.keuangan.ewspersistence.commmon.PersistenceUtils;

import java.util.UUID;

public class PenilaiFilter extends BaseFilter {

    public PenilaiFilter() {
        setPageSize(10);
        setPageNumber(0);
        setSortBy(PersistenceConstant.NAME);
        setSortingOrder(PersistenceConstant.ASC);
    }

    private UUID id;
    private String name;
    private String nip;
    private String seksi;
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public boolean isNameValid() {
        return PersistenceUtils.isStringValid(name);
    }

    public boolean isNipValid() {
        return PersistenceUtils.isStringValid(nip);
    }

    public boolean isSeksiValid() {
        return PersistenceUtils.isStringValid(seksi);
    }

    public boolean isEmailValid() {
        return PersistenceUtils.isStringValid(email);
    }
}
