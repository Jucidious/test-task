package com.jucya.api.controller;

import java.util.List;

/**
 * List of the companies with their availability information.
 */
class GetInsuranceCompanyResponse {

    private final List<GetInsuranceCompanyInfo> companies;

    GetInsuranceCompanyResponse(List<GetInsuranceCompanyInfo> companies) {
        this.companies = companies;
    }

    public List<GetInsuranceCompanyInfo> getCompanies() {
        return companies;
    }

}
