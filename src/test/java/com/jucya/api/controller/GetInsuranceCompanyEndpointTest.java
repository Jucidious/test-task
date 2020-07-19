package com.jucya.api.controller;

import com.jucya.core.shared.data.FoundCompaniesData;
import com.jucya.core.usecase.GetInsuranceCompanyCase;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

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

    @Before
    void before() {
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    @DisplayName("violates a blank id")
    void testValidationBlankId() throws Exception {
        //given
        var id = 1L;
        var inn = 1234L;
        var ogrn = 12345L;
        var fullname = "Apple";
        var address = "Tomsk";
        var result = FoundCompaniesData.ofEmpty();

        //when
        Mockito.when(getInsuranceCompanyCaseMock.execute(Mockito.any())).thenReturn(result);
        var response = mvc.perform(MockMvcRequestBuilders.get("/?inn=1234"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}