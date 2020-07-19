package com.jucya.api.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

/**
 * Provides validation according to {@link com.jucya.api.constraint.Inn}.
 *
 * @see com.jucya.api.constraint.Inn
 */
public class InnValidator implements ConstraintValidator<Inn, Long> {

    private static final Integer[] COEFFICIENTS = {2, 4, 10, 3, 5, 9, 4, 6, 8};

    @Override
    public boolean isValid(Long inn, ConstraintValidatorContext context) {
        if (inn == null || inn < 0) {
            return false;
        }
        var str = inn.toString();
        if (str.length() != 10) {
            return false;
        }
        var arrInt = stringToIntArray(str);
        var result = getChecksum(arrInt);

        return (arrInt[arrInt.length - 1].equals(result));
    }

    private static Integer[] stringToIntArray(String str) {
        var chars = str.toCharArray();
        var digits = new ArrayList<Integer>();
        for (var aChar : chars) {
            digits.add(Character.getNumericValue(aChar));
        }
        return digits.toArray(new Integer[0]);
    }

    private static Integer getChecksum(Integer[] digits) {
        int checksum = 0;
        for (int i = 0; i < COEFFICIENTS.length; i++) {
            checksum += (digits[i] * COEFFICIENTS[i]);
        }
        return (checksum % 11) % 10;
    }
}
