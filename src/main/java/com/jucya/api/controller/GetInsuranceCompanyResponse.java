package com.jucya.api.controller;

import java.util.List;

class GetInsuranceCompanyResponse {

    private final List<GetInsuranceCompanyInfo> companies;

    GetInsuranceCompanyResponse(List<GetInsuranceCompanyInfo> companies) {
        this.companies = companies;
    }

    public List<GetInsuranceCompanyInfo> getCompanies() {
        return companies;
    }

}
