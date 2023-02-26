package com.doccms.domain.model;

import java.util.Set;

public record DocumentType(

    String name,
    Set<Field> fields

) {


}
