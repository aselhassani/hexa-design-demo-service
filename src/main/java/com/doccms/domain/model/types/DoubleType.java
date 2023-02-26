package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;

public class DoubleType extends PrimitiveType {

    private static final String ID = "double";

    public DoubleType(Set<Constraint> constraints) {
        super(ID, constraints);
    }

    @Override
    public boolean validate(Object object) {
        return object instanceof Number;
    }

    @Override
    public Object parse(Object o) {
        return switch (o) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> Double.parseDouble(s);
            default -> 0d;
        };
    }
}
