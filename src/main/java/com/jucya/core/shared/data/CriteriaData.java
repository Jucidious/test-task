package com.jucya.core.shared.data;

/**
 * Describes a criteria property.
 */
public class CriteriaData {

    private final String name;
    private final Object value;

    public static CriteriaData of(String name, Object value) {
        return new CriteriaData(name, value);
    }

    CriteriaData(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
