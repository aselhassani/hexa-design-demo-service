package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;

public class BooleanType extends PrimitiveType {

    public static final String ID = "boolean";

    public BooleanType(Set<Constraint> constraints) {
        super(ID, constraints);
    }

    @Override
    public boolean validate(Object o) {
        return o instanceof Boolean;
    }

    @Override
    public Boolean parse(Object o) {
        return switch (o) {
            case Boolean b -> b;
            case Integer i -> i != 0 ? Boolean.TRUE : Boolean.FALSE;
            case String s -> Boolean.valueOf(s);
            default -> false;
        };
    }
}
