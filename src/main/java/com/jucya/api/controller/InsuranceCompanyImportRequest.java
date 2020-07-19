package com.jucya.api.controller;

import com.jucya.api.constraint.Inn;
import com.jucya.api.constraint.Ogrn;

import javax.validation.constraints.NotBlank;


class InsuranceCompanyImportRequest {

    @Inn
    private Long inn;

    @Ogrn
    private Long ogrn;

    @NotBlank
    private String fullname;

    @NotBlank
    private String address;

    private InsuranceCompanyImportRequest() {
    }

    InsuranceCompanyImportRequest(Long inn, Long ogrn, String fullname, String address) {
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
