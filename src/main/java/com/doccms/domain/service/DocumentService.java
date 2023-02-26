package com.doccms.domain.service;

import java.util.List;
import java.util.Optional;

import com.doccms.port.repository.DocumentRepository;
import com.doccms.domain.model.Document;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;

    public Optional<Document> createDocument(Document document) {
        return repository.createDocument(document);
    }

    public List<Document> findDocuments() {
        return repository.findDocuments();
    }
}
