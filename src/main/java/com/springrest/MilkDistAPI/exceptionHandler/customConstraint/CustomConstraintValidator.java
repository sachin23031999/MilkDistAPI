package com.springrest.MilkDistAPI.exceptionHandler.customConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomConstraintValidator implements
        ConstraintValidator<CustomConstraint, String> {

    private CustomConstraint annotation;
    @Override
    public void initialize(CustomConstraint annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext cxt) {

        return fieldValue != null && fieldValue.matches(annotation.pattern())
                //&& (fieldValue.length() == annotation.length())
                && (fieldValue.length() >= annotation.lower() && fieldValue.length() <= annotation.upper());
    }

}