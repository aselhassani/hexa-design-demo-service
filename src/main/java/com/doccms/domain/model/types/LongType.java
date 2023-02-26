package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;

public class LongType extends PrimitiveType {

    public static final String ID = "long";

    public LongType(Set<Constraint> constraints) {
        super(ID, constraints);
    }

    @Override
    public boolean validate(Object object) {
        return false;
    }

    @Override
    public Long parse(Object o) {
        return switch (o) {
            case Integer i -> i.longValue();
            case Float f -> f.longValue();
            case String s -> Long.valueOf(s);
            default -> 0l;
        };
    }
}
