package com.springrest.MilkDistAPI.exceptionHandler.customConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomConstraint {
    String message() default "";
    int lower() default 2;
    int upper() default 10;
    int length() default 10;
    String pattern() default ".";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}