package com.doccms.domain.model;

import java.time.Instant;
import java.util.Set;

import lombok.Builder;

@Builder
public record Document(

    Long documentId,

    String documentType,
    String title,
    String description,

    String owner,

    Set<String> contributors,

    String format,

    String language,

    Instant createdAt,

    Instant updatedAt

) {
}
