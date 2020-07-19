package com.jucya.api.controller;

class GetInsuranceCompanyInfo {

    private Long id;
    private Long inn;
    private Long ogrn;
    private String fullname;
    private String address;

    private GetInsuranceCompanyInfo() {
    }

    GetInsuranceCompanyInfo(Long id, Long inn, Long ogrn, String fullname, String address) {
        this.id = id;
        this.inn = inn;
        this.ogrn = ogrn;
        this.fullname = fullname;
        this.address = address;
    }

    public Long getId() {
        return id;
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
