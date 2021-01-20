package com.oktenweb.springbootstpr.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueMovieNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueMovieName {

    String message() default "movie title should be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
