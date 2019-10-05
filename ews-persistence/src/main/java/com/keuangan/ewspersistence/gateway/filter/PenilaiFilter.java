package com.keuangan.ewspersistence.gateway.filter;

import com.keuangan.ewspersistence.commmon.PersistenceConstant;

import java.util.UUID;

public class PenilaiFilter {

    public PenilaiFilter() {
        pageSize = 10;
        pageNumber = 0;
        sortBy = PersistenceConstant.NAME;
        sortingOrder = PersistenceConstant.ASC;
    }

    private UUID id;
    private String name;
    private String nip;
    private String seksi;
    private String email;
    private int pageSize;
    private int pageNumber;
    private String sortBy;
    private String sortingOrder;

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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public boolean isIdValid() {
        return null != id;
    }

    public boolean isNameValid() {
        return null != name && !name.trim().isEmpty();
    }

    public boolean isNipValid() {
        return null != nip && !nip.trim().isEmpty();
    }

    public boolean isSeksiValid() {
        return null != seksi && !seksi.trim().isEmpty();
    }

    public boolean isEmailValid() {
        return null != email && !email.trim().isEmpty();
    }
}
