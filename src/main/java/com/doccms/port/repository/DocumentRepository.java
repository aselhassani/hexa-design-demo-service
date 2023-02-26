package com.doccms.port.repository;

import java.util.List;
import java.util.Optional;

import com.doccms.domain.model.Document;

public interface DocumentRepository {
    Optional<Document> createDocument(Document post);

    List<Document> findDocuments();
}
