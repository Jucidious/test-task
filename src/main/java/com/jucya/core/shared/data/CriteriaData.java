package com.jucya.core.shared.data;

import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

/**
 * Describes a lead property metadata.
 *
 * @since 0.5
 */
public class CriteriaData {

    private final String name;
    private final Object value;

    public static CriteriaData of(String name, Object value) {
        return new CriteriaData(name, value);
    }

    CriteriaData(String name, Object value) {
        this.name = Objects.requireNonNull(name);
        this.value = Objects.requireNonNull(value);
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    /**
     * Converts, if it requires, the property
     * value to string representation.
     *
     * @return property value as a string
     */
    public String asString() {
        return value.toString();
    }


}
