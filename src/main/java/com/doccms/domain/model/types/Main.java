package com.doccms.domain.model.types;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        BooleanType booleanType = new BooleanType(Collections.emptySet());
        booleanType.validate(null);
    }
}
