package com.jucya.core.shared.data;

import java.util.Collections;
import java.util.List;

public class FoundCompaniesData {
    private final List<CompanyData> companies;

    public static FoundCompaniesData ofEmpty() {
        return new FoundCompaniesData(Collections.EMPTY_LIST);
    }

    public FoundCompaniesData(List<CompanyData> companies) {
        this.companies = companies;
    }

    public List<CompanyData> getCompanies() {
        return companies;
    }

}
