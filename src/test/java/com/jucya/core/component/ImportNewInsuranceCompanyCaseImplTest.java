package com.jucya.core.component;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.shared.domain.InsuranceCompany;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import com.jucya.exception.CompanyDuplicateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

/**
 * Test suite for {@link com.jucya.core.component.ImportNewInsuranceCompanyCaseImpl}.
 */
@DisplayName("ImportNewInsuranceCompanyCaseImpl")
class ImportNewInsuranceCompanyCaseImplTest {

    private ImportNewInsuranceCompanyCase importNewInsuranceCompanyCaseMock;
    private InsuranceCompanyRepository insuranceCompanyRepositoryMock;

    @BeforeEach
    void setUp() {
        insuranceCompanyRepositoryMock = Mockito.mock(InsuranceCompanyRepository.class);
        importNewInsuranceCompanyCaseMock = new ImportNewInsuranceCompanyCaseImpl(insuranceCompanyRepositoryMock);
    }

    @Test
    @DisplayName("")
    void testSuccessfull() {
        //given
        var id = 1L;
        var inn = 1234L;
        var ogrn = 12345L;
        var fullname = "Apple";
        var address = "Tomsk";
        var localCompany = new InsuranceCompany();
        localCompany.setId(id);
        localCompany.setInn(inn);
        localCompany.setOgrn(ogrn);
        localCompany.setFullname(fullname);
        localCompany.setAddress(address);
        var data = new InsuranceCompanyNewData(inn, ogrn, fullname, address);
        Optional<InsuranceCompany> result = Optional.of(localCompany);

        //when
        Mockito.when(insuranceCompanyRepositoryMock.findByInnAndOgrn(Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(result);
        var thrown = Assertions.catchThrowable(() -> importNewInsuranceCompanyCaseMock.execute(data));

        //then
        Assertions.assertThat(thrown).isInstanceOf(CompanyDuplicateException.class);
        Assertions.assertThat(thrown.getMessage()).isEqualTo("This \"Apple\" company already exists");
    }
}