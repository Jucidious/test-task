package com.jucya.core.usecase;

import java.util.List;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;

/**
 * Use case that describes obtaining company information.
 */
public interface GetInsuranceCompanyCase {

    /**
     * Gets company information from DB.
     *
     * @param searchCriteria list criteria properties
     * @return obtained company information
     */
    FoundCompaniesData execute(List<CriteriaData> searchCriteria);
}
