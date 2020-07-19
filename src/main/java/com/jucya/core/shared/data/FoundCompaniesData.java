package com.jucya.core.shared.data;

import java.util.Collections;
import java.util.List;

/**
 * List of the companies with their information.
 */
public class FoundCompaniesData {
    private final List<CompanyData> companies;

    public static FoundCompaniesData ofEmpty() {
        return new FoundCompaniesData(Collections.emptyList());
    }

    public FoundCompaniesData(List<CompanyData> companies) {
        this.companies = companies;
    }

    public List<CompanyData> getCompanies() {
        return companies;
    }

}
