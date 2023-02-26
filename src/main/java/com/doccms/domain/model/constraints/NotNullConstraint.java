package com.doccms.domain.model.constraints;

import com.doccms.domain.model.Constraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotNullConstraint implements Constraint {

    private static final NotNullConstraint instance = new NotNullConstraint();

    public static NotNullConstraint getInstance() {
        return instance;
    }

    @Override
    public boolean validate(Object object) {
        return object != null;
    }

}
