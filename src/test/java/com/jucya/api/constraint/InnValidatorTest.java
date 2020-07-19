package com.jucya.api.constraint;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite for {@link com.jucya.api.constraint.InnValidator}.
 */
@DisplayName("InnValidator")
class InnValidatorTest {

    private InnValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InnValidator();
    }

    @Test
    @DisplayName("violates a null inn")
    void testNullInn() {
        // given
        Long innNull = null;

        // when
        var isValid = validator.isValid( innNull, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("violates a negative inn")
    void testNegativeInn() {
        // given
        var inn = -7707767220L;

        // when
        var isValid = validator.isValid( inn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("incorrect length inn")
    void testIncorrectLengthInn() {
        // given
        var inn = 770776L;

        // when
        var isValid = validator.isValid( inn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("incorrect control sum inn")
    void testInCorrectControlSum() {
        // given
        var inn = 7707767229L;

        // when
        var isValid = validator.isValid( inn, null);

        // then
        Assertions.assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Correct control sum inn")
    void testCorrectControlSum() {
        // given
        var inn = 7707767220L;

        // when
        var isValid = validator.isValid( inn, null);

        // then
        Assertions.assertThat(isValid).isTrue();
    }

}
