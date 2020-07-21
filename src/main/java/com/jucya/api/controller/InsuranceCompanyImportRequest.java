package com.jucya.api.controller;

import com.jucya.api.constraint.Inn;
import com.jucya.api.constraint.Ogrn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(max = 500)
    private String organization;

    @NotBlank
    @Size(max = 1000)
    private String address;

    InsuranceCompanyImportRequest() {
    }

    InsuranceCompanyImportRequest(Long inn, Long ogrn, String organization, String address) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.organization = organization;
        this.address = address;
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

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public void setOgrn(Long ogrn) {
        this.ogrn = ogrn;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
