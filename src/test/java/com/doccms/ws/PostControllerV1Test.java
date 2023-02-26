package com.doccms.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.doccms.helpers.DomainHelper;
import com.doccms.ws.dto.DocumentRequestV1DTO;
import com.doccms.domain.model.Document;
import com.doccms.domain.service.DocumentService;
import com.doccms.helpers.DtoHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class PostControllerV1Test {

    @InjectMocks
    private DocumentControllerV1 underTest;

    @Mock
    private DocumentService postService;

    private Document post;

    private DocumentRequestV1DTO postDto;

    @BeforeEach
    void setup() {
        postDto = DtoHelper.randomPostRequestV1Dto();
        post = DomainHelper.randomPost();
    }

    @Test
    void createPostShouldCreatePostAndReturnOK() {
        when(postService.createDocument(any())).thenReturn(Optional.of(post));

        var result = underTest.createPost(postDto);

        ArgumentCaptor<Document> captor = ArgumentCaptor.forClass(Document.class);

        verify(postService).createDocument(captor.capture());

        var iPost = captor.getValue();

        assertThat(postDto).usingRecursiveComparison().isEqualTo(iPost);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(result.getBody()).usingRecursiveComparison().isEqualTo(post);
    }

    @Test
    void getPostsShouldRetrievePostsAndReturnOK() {
        when(postService.findDocuments()).thenReturn(List.of(post));

        var result = underTest.getPosts();

        verify(postService).findDocuments();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(result.getBody().get(0)).usingRecursiveComparison().isEqualTo(post);
    }

    @Test
    void getPostsShouldRetrieveEmptyIfNoPostFound() {
        when(postService.findDocuments()).thenReturn(Collections.emptyList());

        var result = underTest.getPosts();

        verify(postService).findDocuments();

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(result.getBody()).isEmpty();
    }
}
