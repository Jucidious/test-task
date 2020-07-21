package com.jucya.core.component;

import java.util.List;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.shared.domain.Company;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Test suite for {@link com.jucya.core.component.GetInsuranceCompanyCaseImpl}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("GetInsuranceCompanyCaseImpl")
class GetInsuranceCompanyCaseImplTest {

    private GetInsuranceCompanyCase getInsuranceCompanyCase;

    @Resource
    private InsuranceCompanyRepository insuranceCompanyRepository;

    @BeforeEach
    void setUp() {
        getInsuranceCompanyCase = new GetInsuranceCompanyCaseImpl(insuranceCompanyRepository);
    }

    @Test
    @DisplayName("successful when right variables and result is empty")
    void testSuccessfulWhenResultIsEmpty() {
        //given
        var criteriaData = List.of(CriteriaData.of("inn", 7702235133L),
                CriteriaData.of("address", "Moscow"));

        //when
        var expectResult = getInsuranceCompanyCase.execute(criteriaData);

        //then
        Assertions.assertThat(expectResult).isInstanceOf(FoundCompaniesData.class);
        Assertions.assertThat(expectResult.getCompanies()).isEmpty();
    }

    @Test
    @DisplayName("successful when right variables and result is not empty")
    void testSuccessfulWhenResultIsNotEmpty() {
        //given
        var criteriaData = List.of(CriteriaData.of("inn", 2460048358L),
                CriteriaData.of("address", "Krasnoyarsk"));
        var inn = 2460048358L;
        var ogrn = 1022401785658L;
        var organization = "SibUgol";
        var address = "Krasnoyarsk";
        var localCompany = new Company();
        localCompany.setInn(inn);
        localCompany.setOgrn(ogrn);
        localCompany.setOrganization(organization);
        localCompany.setAddress(address);

        //when
        insuranceCompanyRepository.save(localCompany);
        var expectResult = getInsuranceCompanyCase.execute(criteriaData);

        //then
        Assertions.assertThat(expectResult).isInstanceOf(FoundCompaniesData.class);
        Assertions.assertThat(expectResult.getCompanies().size()).isEqualTo(1);
        Assertions.assertThat(expectResult.getCompanies().get(0).getInn()).isEqualTo(2460048358L);
        Assertions.assertThat(expectResult.getCompanies().get(0).getOgrn()).isEqualTo(1022401785658L);
        Assertions.assertThat(expectResult.getCompanies().get(0).getOrganization()).isEqualTo("SibUgol");
        Assertions.assertThat(expectResult.getCompanies().get(0).getAddress()).isEqualTo("Krasnoyarsk");
    }

}