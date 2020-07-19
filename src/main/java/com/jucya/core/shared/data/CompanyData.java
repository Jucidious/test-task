package com.jucya.core.shared.data;

public class CompanyData {
    private final Long id;
    private final Long inn;
    private final Long ogrn;
    private final String fullname;
    private final String address;

    public static CompanyData of(Long id, Long inn, Long ogrn, String fullname, String address) {
        return  new CompanyData(id, inn, ogrn, fullname, address);
    }

    CompanyData(Long id, Long inn, Long ogrn, String fullname, String address) {
        this.id = id;
        this.inn = inn;
        this.ogrn = ogrn;
        this.fullname = fullname;
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

    public String getFullname() {
        return fullname;
    }

    public String getAddress() {
        return address;
    }

}
