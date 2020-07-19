package com.jucya.core.component;

import com.jucya.core.usecase.GetInsuranceCompanyCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures get company information components.
 */
@Configuration
public class GetConfig {

    @Bean
    public GetInsuranceCompanyCase getInsuranceCompanyCase() {
        return new GetInsuranceCompanyCaseImpl();
    }

}
