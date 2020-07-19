package com.jucya.api.controller;

import com.jucya.api.constraint.Inn;
import com.jucya.api.constraint.Ogrn;

import javax.validation.constraints.NotBlank;

/**
 * Describes a companies to be checked
 * against availability in DB.
 */
class InsuranceCompanyImportRequest {

    @Inn
    private Long inn;

    @Ogrn
    private Long ogrn;

    @NotBlank
    private String organizationName;

    @NotBlank
    private String address;

    private InsuranceCompanyImportRequest() {
    }

    InsuranceCompanyImportRequest(Long inn, Long ogrn, String organizationName, String address) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.organizationName = organizationName;
        this.address = address;
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
