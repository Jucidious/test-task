package com.jucya.api.controller;

import com.jucya.core.shared.data.InsuranceCompanyNewData;
import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Endpoint to import company information.
 */
@Controller
public class InsuranceCompanyImportEndpoint {

    private final ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase;

    public InsuranceCompanyImportEndpoint(ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase) {
        this.importNewInsuranceCompanyCase = importNewInsuranceCompanyCase;
    }

    @RequestMapping(value="/importForm", method= RequestMethod.GET)
    public String importForm(InsuranceCompanyImportRequest request, Model model) {
        model.addAttribute("request", request);
        return "import";
    }

    @RequestMapping(value="/import", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String importCompany(@Valid @ModelAttribute("request") InsuranceCompanyImportRequest request,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "import";
        }
        var result = importNewInsuranceCompanyCase.execute(
                new InsuranceCompanyNewData(
                        request.getInn(),
                        request.getOgrn(),
                        request.getOrganization(),
                        request.getAddress()
                )
        );
        model.addAttribute("result", result);
        model.addAttribute("request", new InsuranceCompanyImportRequest());
        return "import";
    }

}
