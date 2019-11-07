package com.keuangan.ewspersistence.penilaian.gateway.penilaian;

import com.keuangan.ewspersistence.commmon.PersistenceConstant;
import com.keuangan.ewspersistence.commmon.PersistenceUtils;
import com.keuangan.ewspersistence.gateway.filter.BaseFilter;

public class PenilaianFilter extends BaseFilter {

    public PenilaianFilter() {
        setPageSize(10);
        setPageNumber(0);
        setSortBy(PersistenceConstant.NO_SURAT_PERMOHONAN);
        setSortingOrder(PersistenceConstant.DESC);
    }

    private String noSuratPermohonan;
    private String tanggalPenilaian;
    private String tanggalDisposisi;
    private String deskripsiObjek;
    private String satker;
    private String kl;
    private String verifikator;
    private String status;
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

    public boolean isNoSuratPermohonanValid() {
        return PersistenceUtils.isStringValid(noSuratPermohonan);
    }

    public boolean isTanggalPenilaianValid() {
        return PersistenceUtils.isStringValid(tanggalPenilaian);
    }

    public boolean isTanggalDisposisiValid() {
        return PersistenceUtils.isStringValid(tanggalDisposisi);
    }

    public boolean isDeskripsiObjekValid() {
        return PersistenceUtils.isStringValid(deskripsiObjek);
    }

    public boolean isSatkerValid() {
        return PersistenceUtils.isStringValid(satker);
    }

    public boolean isKlValid() {
        return PersistenceUtils.isStringValid(kl);
    }

    public boolean isVerifikatorValid() {
        return PersistenceUtils.isStringValid(verifikator);
    }

    public boolean isStatusValid() {
        return PersistenceUtils.isStringValid(status);
    }

    public boolean isJenisPenilaianValid() {
        return PersistenceUtils.isStringValid(jenisPenilaian);
    }
}
