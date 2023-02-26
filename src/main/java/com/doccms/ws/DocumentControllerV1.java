package com.doccms.ws;

import java.util.List;
import java.util.Optional;

import com.doccms.ws.dto.DocumentRequestV1DTO;
import com.doccms.ws.dto.DocumentResponseV1DTO;
import com.doccms.domain.service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class DocumentControllerV1 {

    private final DocumentService postService;

    @PostMapping
    public ResponseEntity<DocumentResponseV1DTO> createPost(@RequestBody @Valid DocumentRequestV1DTO documentDto) {

        return Optional.of(documentDto)
                       .map(DocumentRequestV1DTO::toDomain)
                       .flatMap(postService::createDocument)
                       .map(DocumentResponseV1DTO::fromDomain)
                       .map(ResponseEntity::ok)
                       .orElse(null);
    }

    @GetMapping
    public ResponseEntity<List<DocumentResponseV1DTO>> getPosts() {
        var documents = postService.findDocuments().stream()
                               .map(DocumentResponseV1DTO::fromDomain)
                               .toList();
        return ResponseEntity.ok(documents);
    }


}
