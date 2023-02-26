package com.doccms.domain.util;

import java.util.Collection;

import com.doccms.domain.model.Constraint;

public class ConstraintUtils {
    @SuppressWarnings("unchecked")
    public static <T extends Constraint> T getConstraint(Collection<Constraint> constraints, Class<T> constraintClass) {
        for (Constraint constraint : constraints) {
            if (constraint.getClass().equals(constraintClass)) {
                return (T) constraint;
            }
        }
        return null;
    }
}
