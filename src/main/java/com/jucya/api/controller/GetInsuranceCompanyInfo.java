package com.jucya.api.controller;

/**
 * Describes a set of company attributes
 * for searching in DB.
 */
class GetInsuranceCompanyInfo {

    private Long id;
    private Long inn;
    private Long ogrn;
    private String organizationName;
    private String address;

    private GetInsuranceCompanyInfo() {
    }

    GetInsuranceCompanyInfo(Long id, Long inn, Long ogrn, String organizationName, String address) {
        this.id = id;
        this.inn = inn;
        this.ogrn = ogrn;
        this.organizationName = organizationName;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

}
