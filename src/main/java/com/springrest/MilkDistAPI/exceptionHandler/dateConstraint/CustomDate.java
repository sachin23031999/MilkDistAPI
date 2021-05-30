package com.springrest.MilkDistAPI.exceptionHandler.dateConstraint;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//@CustomDateValidator
//private LocalDate startDate;

@Documented
@Constraint(validatedBy = CustomDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomDate {
    String pattern() default "yyyy-MM-dd";
    String message() default "Invalid date format";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}