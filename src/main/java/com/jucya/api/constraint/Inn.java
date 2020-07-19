package com.jucya.api.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotated inn for validate control sum.
 *
 * @see InnValidator
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = InnValidator.class)
public @interface Inn {

    /**
     * Message template.
     *
     * @return message template.
     */
    String message() default "{com.jucya.api.constraint.Inn.message}";

    /**
     * Active validation groups.
     *
     * @return validation groups
     */
    Class<?>[] groups() default {};

    /**
     * Additional metadata attached.
     *
     * @return payload
     */
    Class<? extends Payload>[] payload() default {};

}
