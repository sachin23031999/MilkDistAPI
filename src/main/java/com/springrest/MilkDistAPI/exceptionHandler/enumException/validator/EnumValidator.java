package com.springrest.MilkDistAPI.exceptionHandler.enumException.validator;

import com.springrest.MilkDistAPI.enums.TimePeriod;
import com.springrest.MilkDistAPI.exceptionHandler.enumException.Enum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;


public class EnumValidator implements ConstraintValidator<Enum, Object> {

    private Enum annotation;

    @Override
    public void initialize(Enum constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        System.out.println("Object value :" + value);
        Object[] objects = annotation.clazz().getEnumConstants();
//            for(Object ob : objects) {
//                System.out.println("Object :" + ob);
//            }

        try {
            Method method = annotation.clazz().getMethod(annotation.method());
//            for(Object ob : objects) {
//                System.out.println(method.invoke(ob));
//            }
            for (Object o : objects) {
                System.out.println(o);
                if (value.equals(method.invoke(o))) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
