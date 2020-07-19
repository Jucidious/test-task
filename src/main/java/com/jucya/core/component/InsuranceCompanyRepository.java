package com.jucya.core.component;

import java.util.Optional;

import com.jucya.core.shared.domain.InsuranceCompany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {

    Optional<InsuranceCompany> findByInnAndOgrn(Long inn, Long ogrn);

}
