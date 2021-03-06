package com.example.java.bagic;

import java.util.Arrays;
import java.util.List;

public enum EnumExample {

    FIRST("first", 1),
    SECOND("second", 2),
    THIRD("third", 3);

    private String name;
    private Integer value;

    public static final List<EnumExample> CODES = Arrays.asList(values());

    EnumExample(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }
    public Integer getValue() {
        return this.value;
    }

}
