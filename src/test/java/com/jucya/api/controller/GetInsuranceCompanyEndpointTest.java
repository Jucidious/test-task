package com.jucya.api.controller;

import java.util.List;

import com.jucya.core.shared.data.CompanyData;
import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Test suite for {@link com.jucya.api.controller.GetInsuranceCompanyEndpoint}.
 */
@DisplayName("GetInsuranceCompanyEndpoint")
@WebMvcTest(controllers = GetInsuranceCompanyEndpoint.class)
class GetInsuranceCompanyEndpointTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private GetInsuranceCompanyCase getInsuranceCompanyCaseMock;

    @BeforeEach
    void before() {
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    @DisplayName("provides empty result")
    void testSuccessfulWhenResultEmpty() throws Exception {
        //given
        var result = FoundCompaniesData.ofEmpty();

        //when
        Mockito.when(getInsuranceCompanyCaseMock.execute(Mockito.any())).thenReturn(result);
        var response = mvc.perform(MockMvcRequestBuilders.get("/search?inn=7707767220"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.companies").isEmpty());
    }

    @Test
    @DisplayName("provides company result")
    void testSuccessfulWhenResultNotEmpty() throws Exception {
        //given
        var id = 1L;
        var inn = 7707767220L;
        var ogrn = 5117746070019L;
        var organizationName = "Apple";
        var address = "Tomsk";
        var result = new FoundCompaniesData(List.of(CompanyData.of(id, inn, ogrn, organizationName, address)));

        //when
        Mockito.when(getInsuranceCompanyCaseMock.execute(Mockito.any())).thenReturn(result);
        var response = mvc.perform(MockMvcRequestBuilders.get("/search?inn=7707767220&violates=1234"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.companies.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.companies.[0].inn").value(7707767220L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.companies.[0].ogrn").value(5117746070019L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.companies.[0].organizationName").value("Apple"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.companies.[0].address").value("Tomsk"));
    }
}