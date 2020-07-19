package com.jucya.api.controller;

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

/**
 * Test suite for {@link com.jucya.api.controller.InsuranceCompanyImportEndpoint}.
 */
@DisplayName("InsuranceCompanyImportEndpoint")
@WebMvcTest(controllers = InsuranceCompanyImportEndpoint.class)
class InsuranceCompanyImportEndpointTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private ImportNewInsuranceCompanyCase importNewInsuranceCompanyCaseMock;

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

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"1234\",\n"
                        + "    \"ogrn\": \"45343453453\",\n"
                        + "    \"fullname\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

}