package com.doccms.domain.model.types;

import java.util.List;
import java.util.Set;

import com.doccms.domain.model.Constraint;

public class ListType extends FieldType {

    private PrimitiveType type;

    public ListType(String name, Set<Constraint> constraints, PrimitiveType type) {
        super(name, constraints);
        this.type = type;
    }


    @Override
    public boolean validate(Object o) {
        return false;
    }

    @Override
    public Object parse(Object o) {
        if (o instanceof List l) {
            l.stream()
                .map(type::parse)
                .toList();
        }
        return null;
    }
}
