package com.jucya.core.usecase;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;

import java.util.List;

public interface GetInsuranceCompanyCase {

    FoundCompaniesData execute(List<CriteriaData> request);
}
