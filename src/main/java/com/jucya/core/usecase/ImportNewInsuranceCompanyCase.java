package com.jucya.core.usecase;

import com.jucya.core.shared.data.InsuranceCompanyNewData;

/**
 * Use case that describes import company.
 */
public interface ImportNewInsuranceCompanyCase {

    /**
     * Imports a new company into DB.
     *
     * @param data company properties to be imported
     */
    void execute(InsuranceCompanyNewData data);
}
