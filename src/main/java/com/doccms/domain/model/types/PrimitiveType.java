package com.doccms.domain.model.types;

import java.util.Set;

import com.doccms.domain.model.Constraint;
import lombok.AllArgsConstructor;


public abstract class PrimitiveType extends FieldType {


    public PrimitiveType(String name, Set<Constraint> constraints) {
        super(name, constraints);
    }
}
