package com.jucya.api.constraint;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for {@link com.jucya.api.constraint.OgrnValidator}.
 */
@DisplayName("OgrnValidator")
class OgrnValidatorTest {

    private OgrnValidator validator;

    @BeforeEach
    void setUp() {
        validator = new OgrnValidator();
    }

    @Test
    @DisplayName("violates a null ogrn")
    void testNullOgrn() {
        // given
        Long ogrnNull = null;

        // when
        var isValid = validator.isValid( ogrnNull, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("violates a negative ogrn")
    void testNegativeOgrn() {
        // given
        var ogrn = -5117746070019L;

        // when
        var isValid = validator.isValid( ogrn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("incorrect length ogrn")
    void testIncorrectLengthInn() {
        // given
        var ogrn = 511774607L;

        // when
        var isValid = validator.isValid( ogrn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("incorrect control ogrn")
    void testInCorrectControlSum() {
        // given
        var ogrn = 5117746070013L;

        // when
        var isValid = validator.isValid( ogrn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Correct control sum ogrn")
    void testCorrectControlSum() {
        // given
        var ogrn = 5117746070019L;

        // when
        var isValid = validator.isValid( ogrn, null);

        // then
        Assertions.assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Correct ogrn when control sum zero")
    void testCorrectControlSumWhenZero() {
        // given
        var ogrn = 1024201464100L;

        // when
        var isValid = validator.isValid( ogrn, null);

        // then
        Assertions.assertThat(isValid).isTrue();
    }

}
