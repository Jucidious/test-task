package com.jucya.core.shared.data;

/**
 * Describes a criteria for query.
 */
public enum CriteriaEnumData {
    INN("inn"),
    OGRN("ogrn"),
    ORGANIZATION_NAME("organizationName"),
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
