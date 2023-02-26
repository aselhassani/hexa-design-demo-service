package com.doccms.domain.model;

import java.util.Set;

import com.doccms.domain.model.constraints.NotNullConstraint;
import com.doccms.domain.model.types.FieldType;
import com.doccms.domain.util.ConstraintUtils;

public record Field (
    String name,
    FieldType type,
    String defaultValue,
    Set<Constraint> constraints
) {


}
