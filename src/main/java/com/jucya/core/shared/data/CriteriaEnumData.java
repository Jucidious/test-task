package com.jucya.core.shared.data;

public enum CriteriaEnumData {
    INN("inn"),
    OGRN("ogrn"),
    FULLNAME("fullname"),
    ADDRESS("address");

    private final String criteria;

    public static boolean fromValue(String value) {
        for (CriteriaEnumData enumCriteria : values()) {
            if (enumCriteria.criteria.equals(value)) {
                return true;
            }
        }
        return false;
    }

    CriteriaEnumData(String criteria) {
        this.criteria = criteria;
    }

    public String getCriteria() {
        return criteria;
    }
}
