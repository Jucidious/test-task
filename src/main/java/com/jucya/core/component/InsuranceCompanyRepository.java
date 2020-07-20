package com.jucya.core.component;

import java.util.List;

import com.jucya.core.shared.domain.Company;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Provides persistence access to the gets and imported companies.
 */
@Repository
interface InsuranceCompanyRepository extends JpaRepository<Company, Long>,
        JpaSpecificationExecutor<Company> {

    List<Company> findAll(Specification spec);

}
