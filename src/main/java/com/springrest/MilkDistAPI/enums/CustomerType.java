package com.springrest.MilkDistAPI.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CustomerType {
    individual, professional

//    private static final Map<String, CustomerType> NAME_MAP = Stream.of(values())
//            .collect(Collectors.toMap(CustomerType::toString, Function.identity()));
//
//    public static CustomerType fromString(final String name) {
//        CustomerType myEnum = NAME_MAP.get(name);
//        if (null == myEnum) {
//            throw new IllegalArgumentException(
//                    String.format("'%s' has no corresponding value. Accepted values: %s", name, Arrays.asList(values())));
//        }
//        return myEnum;
//
}