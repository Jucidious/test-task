package com.jucya.core.component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.shared.data.CompanyData;
import com.jucya.core.usecase.GetInsuranceCompanyCase;
import com.jucya.extention.SpecificationJPA;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
class GetInsuranceCompanyCaseImpl implements GetInsuranceCompanyCase {

    private final InsuranceCompanyRepository insuranceCompanyRepository;

    GetInsuranceCompanyCaseImpl(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    @Override
    public FoundCompaniesData execute(List<CriteriaData> request) {
        var mapCriteria = toMapCriteria(request);
        var inn = mapCriteria.get("inn");
        var ogrn = mapCriteria.get("ogrn");
        var organization = mapCriteria.get("organizationName");
        var address = mapCriteria.get("address");
        var result = insuranceCompanyRepository.findAll(Specification
                .where(SpecificationJPA.withInn(inn))
                .and(SpecificationJPA.withOgrn(ogrn))
                .and(SpecificationJPA.withOrganization(organization))
                .and(SpecificationJPA.withAddress(address)));

        if (result.isEmpty()) {
            return FoundCompaniesData.ofEmpty();
        }
        return new FoundCompaniesData(
                result.stream()
                        .map(company -> CompanyData.of(
                                company.getId(),
                                company.getInn(),
                                company.getOgrn(),
                                company.getOrganization(),
                                company.getAddress()))
                        .collect(Collectors.toList())
        );

    }

    private Map<String, Object> toMapCriteria(List<CriteriaData> request) {
        return request.stream()
                .collect(Collectors.toMap(CriteriaData::getName, CriteriaData::getValue));
    }

}
