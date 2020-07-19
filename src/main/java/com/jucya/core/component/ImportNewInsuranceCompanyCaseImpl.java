package com.jucya.core.component;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.shared.domain.InsuranceCompany;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import com.jucya.exception.CompanyDuplicateException;

class ImportNewInsuranceCompanyCaseImpl implements ImportNewInsuranceCompanyCase {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    ImportNewInsuranceCompanyCaseImpl(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Override
    public void execute(InsuranceCompanyNewData data) {
        var inn = data.getInn();
        var ogrn = data.getOgrn();
        insuranceCompanyRepository.findByInnAndOgrn(inn, ogrn)
                .ifPresentOrElse(result -> throwCompanyDuplicate(result.getOrganizationName()),
                        () -> saveInsuranceCompany(data)
                );
    }

    private void saveInsuranceCompany(InsuranceCompanyNewData data) {
        var company = new InsuranceCompany();
        company.setInn(data.getInn());
        company.setOgrn(data.getOgrn());
        company.setOrganizationName(data.getOrganizationName());
        company.setAddress(data.getAddress());
        insuranceCompanyRepository.save(company);
    }

    private void throwCompanyDuplicate(String organizationName) {
        throw new CompanyDuplicateException(organizationName);
    }
}
