package com.jucya.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.jucya.core.shared.data.CriteriaEnumData;
import com.jucya.core.shared.data.CriteriaData;
import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Endpoint to get company information.
 */
@Controller
public class GetInsuranceCompanyEndpoint {

    private final GetInsuranceCompanyCase getInsuranceCompanyCase;

    public GetInsuranceCompanyEndpoint(GetInsuranceCompanyCase getInsuranceCompanyCase) {
        this.getInsuranceCompanyCase = getInsuranceCompanyCase;
    }

    @RequestMapping(value = "/searchForm", method = RequestMethod.GET)
    public String searchForm(Model model) {
        model.addAttribute("request", new HashMap<>());
        return "search";
    }

    /**
     * Gets company information.
     *
     * @return list of the companies information
     */
    @RequestMapping(value="/search", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getCompany(@RequestParam Map<String, Object> request, Model model) {
        var listKey = request.entrySet().stream()
                .filter(key ->
                        CriteriaEnumData.fromValue(key.getKey()) && !(key.getValue().toString().isBlank()))
                .map(property -> CriteriaData.of(property.getKey(), property.getValue()))
                .collect(Collectors.toList());
        var result = getInsuranceCompanyCase.execute(listKey);
        var response = new GetInsuranceCompanyResponse(result.getCompanies().stream()
                .map(data -> new GetInsuranceCompanyInfo(
                        data.getId(),
                        data.getInn(),
                        data.getOgrn(),
                        data.getOrganization(),
                        data.getAddress()
                ))
                .collect(Collectors.toList()));
        model.addAttribute("response", response);
        return "result";
    }

}
