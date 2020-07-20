package com.jucya.api.controller;

import java.util.Map;
import java.util.stream.Collectors;

import com.jucya.core.shared.data.CriteriaEnumData;
import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoint to get company information.
 */
@RestController
@RequestMapping("/search")
public class GetInsuranceCompanyEndpoint {

    private final GetInsuranceCompanyCase getInsuranceCompanyCase;

    public GetInsuranceCompanyEndpoint(GetInsuranceCompanyCase getInsuranceCompanyCase) {
        this.getInsuranceCompanyCase = getInsuranceCompanyCase;
    }

    /**
     * Gets company information.
     *
     * @return list of the companies information
     */
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseStatus(HttpStatus.OK)
    public GetInsuranceCompanyResponse getCompany(@RequestParam Map<String, Object> request) {
        var listKey = request.entrySet().stream()
                .filter(key ->
                        CriteriaEnumData.fromValue(key.getKey()) && !(key.getValue().toString().isBlank()))
                .map(property -> CriteriaData.of(property.getKey(), property.getValue()))
                .collect(Collectors.toList());
        var result = getInsuranceCompanyCase.execute(listKey);
        return new GetInsuranceCompanyResponse(result.getCompanies().stream()
                .map(data -> new GetInsuranceCompanyInfo(
                        data.getId(),
                        data.getInn(),
                        data.getOgrn(),
                        data.getOrganization(),
                        data.getAddress()
                ))
                .collect(Collectors.toList()));
    }

}
