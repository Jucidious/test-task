package com.jucya.extention;

import com.jucya.core.shared.domain.Company;

public class SpecificationJPA {

    public static org.springframework.data.jpa.domain.Specification<Company> withInn(Object inn) {
        return (root, query, cb) -> inn == null ? null : cb.equal(root.get("inn"), inn);
    }

    public static org.springframework.data.jpa.domain.Specification<Company> withOgrn(Object ogrn) {
        return (root, query, cb) -> ogrn == null ? null : cb.equal(root.get("ogrn"), ogrn);
    }

    public static org.springframework.data.jpa.domain.Specification<Company> withOrganization(Object name) {
        return (root, query, cb) -> name == null ? null : cb.equal(root.get("organization"), name);
    }

    public static org.springframework.data.jpa.domain.Specification<Company> withAddress(Object address) {
        return (root, query, cb) -> address == null ? null : cb.equal(root.get("address"), address);
    }

}
