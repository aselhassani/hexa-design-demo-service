package com.doccms.ws.dto;

import com.doccms.domain.model.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record DocumentRequestV1DTO(
    @NotBlank
    String title,
    @NotBlank
    String description,
    @NotBlank
    String content
) {

    public Document toDomain() {
        return Document.builder()
                       .title(title)
                       .description(description)
                       //.content(content)
                       .build();
    }

}