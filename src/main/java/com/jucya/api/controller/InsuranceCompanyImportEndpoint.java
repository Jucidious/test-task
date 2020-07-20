package com.jucya.api.controller;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Endpoint to import company information.
 */
@RestController
@RequestMapping("/import")
public class InsuranceCompanyImportEndpoint {

    private final ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase;

    public InsuranceCompanyImportEndpoint(ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase) {
        this.importNewInsuranceCompanyCase = importNewInsuranceCompanyCase;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void importCompany(@Valid @RequestBody InsuranceCompanyImportRequest request) {
        importNewInsuranceCompanyCase.execute(
                new InsuranceCompanyNewData(
                        request.getInn(),
                        request.getOgrn(),
                        request.getOrganization(),
                        request.getAddress()
                )
        );
    }

}
