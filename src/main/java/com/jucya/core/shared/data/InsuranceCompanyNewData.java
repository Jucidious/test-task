package com.jucya.core.shared.data;

/**
 * Describes a company to be imported into DB.
 */
public class InsuranceCompanyNewData {

    private final Long inn;
    private final Long ogrn;
    private final String organization;
    private final String address;

    public InsuranceCompanyNewData(Long inn, Long ogrn, String organization, String address) {
        this.inn = inn;
        this.ogrn = ogrn;
        this.organization = organization;
        this.address = address;
    }

    public Long getInn() {
        return inn;
    }

    public Long getOgrn() {
        return ogrn;
    }

    public String getOrganization() {
        return organization;
    }

    public String getAddress() {
        return address;
    }

}
