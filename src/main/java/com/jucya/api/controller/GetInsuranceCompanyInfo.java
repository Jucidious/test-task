package com.jucya.api.controller;

/**
 * Describes a set of company attributes
 * for searching in DB.
 */
class GetInsuranceCompanyInfo {

    private Long id;
    private Long inn;
    private Long ogrn;
    private String organization;
    private String address;

    private GetInsuranceCompanyInfo() {
    }

    GetInsuranceCompanyInfo(Long id, Long inn, Long ogrn, String organization, String address) {
        this.id = id;
        this.inn = inn;
        this.ogrn = ogrn;
        this.organization = organization;
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

    public String getOrganization() {
        return organization;
    }

    public String getAddress() {
        return address;
    }

}
