package com.jucya.core.component;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.shared.domain.InsuranceCompany;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import com.jucya.exception.CompanyDuplicateException;

public class ImportNewInsuranceCompanyCaseImpl implements ImportNewInsuranceCompanyCase {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    public ImportNewInsuranceCompanyCaseImpl(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Override
    public void execute(InsuranceCompanyNewData data) {
        var inn = data.getInn();
        var ogrn = data.getOgrn();
        insuranceCompanyRepository.findByInnAndOgrn(inn, ogrn)
                .ifPresentOrElse(result -> throwCompanyDuplicate(data.getFullname()),
                        () -> saveInsuranceCompany(data)
                );
    }

    private void saveInsuranceCompany(InsuranceCompanyNewData data) {
        var company = new InsuranceCompany();
        company.setInn(data.getInn());
        company.setOgrn(data.getOgrn());
        company.setFullname(data.getFullname());
        company.setAddress(data.getAddress());
        insuranceCompanyRepository.save(company);
    }

    private void throwCompanyDuplicate(String fullname) {
        throw new CompanyDuplicateException(fullname);
    }
}
