package com.doccms.repository;

import java.util.List;
import java.util.Optional;

import com.doccms.repository.entity.DocumentEntity;
import com.doccms.domain.model.Document;
import com.doccms.port.repository.DocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DocumentJpaRepository implements DocumentRepository {

    private final DocumentJpaEntityRepository repository;

    @Override
    public Optional<Document> createDocument(Document post) {
        return Optional.of(post)
                       .map(DocumentEntity::fromDomain)
                       .map(repository::save)
                       .map(DocumentEntity::toDomain);
    }

    @Override
    public List<Document> findDocuments() {
        throw new RuntimeException("not yet implemented");
    }
}
