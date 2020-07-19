package com.jucya.core.component;

import com.jucya.core.usecase.ImportNewInsuranceCompanyCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportConfig {

    @Bean
    public ImportNewInsuranceCompanyCase importNewInsuranceCompanyCase(
            InsuranceCompanyRepository insuranceCompanyRepository
    ) {
        return new ImportNewInsuranceCompanyCaseImpl(insuranceCompanyRepository);
    }
}
