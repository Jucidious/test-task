package com.jucya.core.component;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.shared.domain.Company;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import com.jucya.extension.SpecificationJPA;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 * Provides an implementation to import company.
 */
@Component
class ImportNewInsuranceCompanyCaseImpl implements ImportNewInsuranceCompanyCase {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    ImportNewInsuranceCompanyCaseImpl(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Override
    public String execute(InsuranceCompanyNewData data) {
        var inn = data.getInn();
        var ogrn = data.getOgrn();
        var organization = data.getOrganization();
        var address = data.getAddress();
        var result = insuranceCompanyRepository.findAll(Specification
                .where(SpecificationJPA.withInn(inn))
                .and(SpecificationJPA.withOgrn(ogrn))
                .and(SpecificationJPA.withOrganization(organization))
                .and(SpecificationJPA.withAddress(address)));
        if (!result.isEmpty()) {
            return "exists";
        }
        saveInsuranceCompany(data);
        return "success";
    }

    private void saveInsuranceCompany(InsuranceCompanyNewData data) {
        var company = new Company();
        company.setInn(data.getInn());
        company.setOgrn(data.getOgrn());
        company.setOrganization(data.getOrganization());
        company.setAddress(data.getAddress());
        insuranceCompanyRepository.save(company);
    }

}
