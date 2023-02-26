package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;

public class IntegerType extends PrimitiveType {

    public static final String ID = "integer";

    public IntegerType(Set<Constraint> constraints) {
        super(ID, constraints);
    }

    @Override
    public boolean validate(Object object) {
        return false;
    }

    @Override
    public Integer parse(Object o) {
        return switch (o) {
            case Integer i -> i;
            case Float f -> f.intValue();
            case String s -> Integer.valueOf(s);
            default -> 0;
        };
    }
}
