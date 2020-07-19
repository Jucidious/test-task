package com.jucya.core.component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.shared.domain.InsuranceCompany;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Test suite for {@link com.jucya.core.component.GetInsuranceCompanyCaseImpl}.
 */
@DisplayName("GetInsuranceCompanyCaseImpl")
class GetInsuranceCompanyCaseImplTest {

    private GetInsuranceCompanyCase getInsuranceCompanyCaseMock;
    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManager = Mockito.mock(EntityManager.class);
        getInsuranceCompanyCaseMock = new GetInsuranceCompanyCaseImpl();
    }

    @Test
    @DisplayName("successful when right variables")
    void testSuccessful() {
        //given
        var query = Mockito.mock(TypedQuery.class);
        var response = new ArrayList<Object>();
        var criteriaData = List.of(CriteriaData.of("inn", 1234L),
                CriteriaData.of("address", "Tomsk"));
        var resp = query.getResultList();
        //when

//
//        Mockito.when(entityManager.createQuery("")).thenReturn(query);
//
//        List<InsuranceCompany> expected = new ArrayList<>();
//        Mockito.when(query.getResultList()).thenReturn(expected);



        Mockito.when(entityManager.createQuery(Mockito.anyString(), Mockito.any())).thenReturn(query);
        var result = getInsuranceCompanyCaseMock.execute(criteriaData);

        //then
        Assertions.assertThat(result).isInstanceOf(FoundCompaniesData.class);
        Assertions.assertThat(result.getCompanies()).isEmpty();
    }

}