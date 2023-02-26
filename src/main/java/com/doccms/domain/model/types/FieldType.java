package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;
import lombok.AllArgsConstructor;


@AllArgsConstructor

public abstract class FieldType {

    private String name;

    private Set<Constraint> constraints;

    public abstract boolean validate(Object object);

    public abstract Object parse(Object object);

}
