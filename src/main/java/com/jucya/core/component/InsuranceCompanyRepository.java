package com.jucya.core.component;

import java.util.Optional;

import com.jucya.core.shared.domain.InsuranceCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides persistence access to the gets and imported companies.
 */
@Repository
interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {

    /**
     * Finds the companies by their inn and ogrn, if any.
     *
     * @param inn  organization inn
     * @param ogrn organization ogrn
     * @return found companies
     */
    Optional<InsuranceCompany> findByInnAndOgrn(Long inn, Long ogrn);

}
