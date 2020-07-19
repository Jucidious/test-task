package com.jucya.api.constraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotated list of mapping pairs must have only one-to-one relationships.
 *
 *
 * <p>{@code null} or empty lists are considered valid.
 *
 * @see OgrnValidator
 * @since 0.1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OgrnValidator.class)
public @interface Ogrn {

    /**
     * Message template.
     *
     * @return message template.
     */
    String message() default "{com.jucya.api.constraint.Ogrn.message}";

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
