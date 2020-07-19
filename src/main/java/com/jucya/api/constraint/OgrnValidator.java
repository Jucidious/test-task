package com.jucya.api.constraint;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

/**
 * Provides validation according to {@link Ogrn}.
 * Technically speaking, it ensures that both source and target lists contain
 * unique values.
 *
 * @see Ogrn
 * @since 0.1
 */
public class OgrnValidator implements ConstraintValidator<Ogrn, Long> {

    @Override
    public boolean isValid(Long ogrn, ConstraintValidatorContext context) {
        if (ogrn == null || ogrn < 0) {
            return true;
        }
        var str = ogrn.toString();
        if (str.length() != 13) {
            return true;
        }
        var arrInt = stringToIntArray(str);
        var n = ogrn/10;
        var remains = n % 11;
        if (remains == 10 && arrInt[arrInt.length-1] == 0) {
            return false;
        }
        return remains == arrInt[arrInt.length-1];
    }

    private static Integer[] stringToIntArray(String str) {
        var chars = str.toCharArray();
        var digits = new ArrayList<Integer>();
        for (var aChar : chars) {
            digits.add(Character.getNumericValue(aChar));
        }
        return digits.toArray(new Integer[0]);
    }

}
