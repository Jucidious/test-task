package com.jucya.core.component;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.shared.domain.Company;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import com.jucya.extension.SpecificationJPA;

import javax.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test suite for {@link com.jucya.core.component.ImportNewInsuranceCompanyCaseImpl}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DisplayName("ImportNewInsuranceCompanyCaseImpl")
class ImportNewInsuranceCompanyCaseImplTest {

    private ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase;

    @Resource
    private InsuranceCompanyRepository insuranceCompanyRepository;

    @BeforeEach
    void setUp() {
        importNewInsuranceCompanyCase = new ImportNewInsuranceCompanyCaseImpl(insuranceCompanyRepository);
    }

    @Test
    @DisplayName("when the company is already exists")
    void testWhenCompanyExists() {
        //given
        var inn = 7707767220L;
        var ogrn = 5117746070019L;
        var organization = "Apple";
        var address = "Tomsk";
        var localCompany = new Company();
        localCompany.setInn(inn);
        localCompany.setOgrn(ogrn);
        localCompany.setOrganization(organization);
        localCompany.setAddress(address);
        var data = new InsuranceCompanyNewData(inn, ogrn, organization, address);

        //when
        insuranceCompanyRepository.save(localCompany);
        var result = importNewInsuranceCompanyCase.execute(data);

        //then
        Assertions.assertThat(result).isEqualTo("exists");
    }

    @Test
    @DisplayName("successful when right variables")
    void testSuccessfulWhenCompanyImported() {
        //given
        var inn = 7707767220L;
        var ogrn = 5117746070017L;
        var organization = "Apple";
        var address = "Tomsk";
        var data = new InsuranceCompanyNewData(inn, ogrn, organization, address);

        //when
        var result = importNewInsuranceCompanyCase.execute(data);
        var response = insuranceCompanyRepository.findAll(Specification
                .where(SpecificationJPA.withOgrn(ogrn)));

        //then
        Assertions.assertThat(response.size()).isEqualTo(1);
        Assertions.assertThat(response.get(0).getInn()).isEqualTo(7707767220L);
        Assertions.assertThat(response.get(0).getOgrn()).isEqualTo(5117746070017L);
        Assertions.assertThat(response.get(0).getOrganization()).isEqualTo("Apple");
        Assertions.assertThat(response.get(0).getAddress()).isEqualTo("Tomsk");
        Assertions.assertThat(result).isEqualTo("success");
    }

}
