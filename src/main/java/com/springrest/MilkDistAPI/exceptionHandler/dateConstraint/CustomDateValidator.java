package com.springrest.MilkDistAPI.exceptionHandler.dateConstraint;

import com.springrest.MilkDistAPI.exceptionHandler.dateConstraint.CustomDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CustomDateValidator implements ConstraintValidator<CustomDate, String> {

    private CustomDate annotation;

    @Override
    public void initialize(CustomDate annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(String dateFieldValue, ConstraintValidatorContext cxt) {

        if (dateFieldValue.equals(null))
            return false;

        SimpleDateFormat dateFormat = new SimpleDateFormat(annotation.pattern());
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateFieldValue);
            return true;

        } catch (ParseException e) {
            return false;
        }
    }

}
