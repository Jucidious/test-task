package com.jucya.api.controller;

import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @BeforeEach
    void before() {
        mvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }

    @Test
    @DisplayName("violates a blank organization name")
    void testValidationBlankOrganizationName() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a null organization name")
    void testValidationNullOrganizationName() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a blank address")
    void testValidationBlankAddress() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a null address")
    void testValidationNullAddress() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a incorrect inn")
    void testValidationIncorrectInn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767225\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a blank inn")
    void testValidationBlankInn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a null inn")
    void testValidationNullInn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a incorrect ogrn")
    void testValidationIncorrectOgrn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070013\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a blank ogrn")
    void testValidationBlankOgrn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("violates a null ogrn")
    void testValidationNullOgrn() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("imports a company")
    void testSuccessfulWhenCorrectVariables() throws Exception {
        //given

        //when
        var response = mvc.perform(MockMvcRequestBuilders.post("/import")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n"
                        + "    \"inn\": \"7707767220\",\n"
                        + "    \"ogrn\": \"5117746070019\",\n"
                        + "    \"organizationName\": \"Apple\",\n"
                        + "    \"address\": \"Tomsk\"\n"
                        + "}"));

        //then
        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
