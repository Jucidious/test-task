package com.jucya.core.shared.data;

/**
 * Describes a company information.
 */
public class CompanyData {
    private final Long id;
    private final Long inn;
    private final Long ogrn;
    private final String organizationName;
    private final String address;

    public static CompanyData of(Long id, Long inn, Long ogrn, String organizationName, String address) {
        return  new CompanyData(id, inn, ogrn, organizationName, address);
    }

    CompanyData(Long id, Long inn, Long ogrn, String organizationName, String address) {
        this.id = id;
        this.inn = inn;
        this.ogrn = ogrn;
        this.organizationName = organizationName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Long getInn() {
        return inn;
    }

    public Long getOgrn() {
        return ogrn;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

}
