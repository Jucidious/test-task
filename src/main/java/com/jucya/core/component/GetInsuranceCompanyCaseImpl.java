package com.jucya.core.component;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.shared.data.CompanyData;
import com.jucya.core.shared.domain.InsuranceCompany;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class GetInsuranceCompanyCaseImpl implements GetInsuranceCompanyCase {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FoundCompaniesData execute(List<CriteriaData> request) {
        var fields = "fields";
        var table = "InsuranceCompany";
        var criteriaOne = new StringJoiner(" AND ", " ", " ");
        var searchCriteria = new StringBuilder().append("select ").append(fields)
                .append(" from ").append(table).append(" ").append(fields);
        if (!request.isEmpty()) {
            for (CriteriaData oneCrit : request) {
                var strValue = new StringBuilder();
                if (oneCrit.getName().equals("fullname") || oneCrit.getName().equals("address")) {
                    strValue.append("'").append(oneCrit.getValue()).append("'");
                    criteriaOne.add(oneCrit.getName() + "=" + strValue);
                } else {
                    criteriaOne.add(oneCrit.getName() + "=" + oneCrit.getValue());
                }
            }
            searchCriteria.append(" where ").append(criteriaOne);
        }
        var criteriaStr = searchCriteria.toString();
        var result = entityManager.createQuery(
                criteriaStr, InsuranceCompany.class)
                .getResultList();

        if (result.isEmpty()) {
            return FoundCompaniesData.ofEmpty();
        }
        return new FoundCompaniesData(
                result.stream()
                        .map(company -> CompanyData.of(
                                company.getId(),
                                company.getInn(),
                                company.getOgrn(),
                                company.getFullname(),
                                company.getAddress()))
                        .collect(Collectors.toList())
        );

    }

}