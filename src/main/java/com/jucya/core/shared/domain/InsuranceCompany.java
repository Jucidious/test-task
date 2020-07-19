package com.jucya.core.shared.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Local info about an imported company.
 */
@Entity
public class InsuranceCompany{

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long inn;
    @Column
    private Long ogrn;
    @Column
    private String organizationName;
    @Column
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InsuranceCompany company = (InsuranceCompany) o;
        return id.equals(company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getOgrn() {
        return ogrn;
    }

    public void setOgrn(Long ogrn) {
        this.ogrn = ogrn;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
