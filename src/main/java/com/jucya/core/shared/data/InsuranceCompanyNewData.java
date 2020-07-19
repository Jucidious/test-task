package com.jucya.core.shared.data;

public class InsuranceCompanyNewData {

    private final Long inn;
    private final Long ogrn;
    private final String fullname;
    private final String address;

    public InsuranceCompanyNewData(Long inn, Long ogrn, String fullname, String address) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.fullname = fullname;
        this.address = address;
    }

    public Long getInn() {
        return inn;
    }

    public Long getOgrn() {
        return ogrn;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

}
