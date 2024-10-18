package com.bpb.publications.authors.controller;

import com.bpb.publications.authors.exception.BadRequestException;
import com.bpb.publications.authors.exception.ResourceNotFoundException;
import com.bpb.publications.authors.service.impl.AuthorServiceImpl;
import com.bpb.publications.authors.vo.AuthorVO;
import com.bpb.publications.authors.service.AuthorService;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorVOController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AuthorVOController.class);

    private final AuthorService authorService;

    public AuthorVOController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorVO>> getAllAuthors() {
        List<AuthorVO> authors = authorService.getAuthors();
        if (authors == null || authors.isEmpty()) {
            LOGGER.warn("No authors found");
            throw new ResourceNotFoundException("No authors found");
        }
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorVO> getAuthorById(@PathVariable Long id) {
        AuthorVO author = authorService.getAuthor(id);
        if (author == null) {
            LOGGER.warn("No author found with id: {}", id);
            throw new ResourceNotFoundException("No author found with id: " + id);
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<AuthorVO> createAuthor(@RequestBody AuthorVO authorVO) {
        if (authorVO.getId() != null) {
            LOGGER.warn("New author cannot have an ID");
            throw new BadRequestException("New author cannot have an ID");
        }
        AuthorVO createdAuthor = authorService.addAuthor(authorVO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAuthor.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorVO> updateAuthor(@PathVariable Long id, @RequestBody AuthorVO authorVO) {
        if (!id.equals(authorVO.getId())) {
            LOGGER.warn("ID in path and request body must match");
            throw new BadRequestException("ID in path and request body must match");
        }
        AuthorVO updatedAuthor = authorService.updateAuthor(id, authorVO);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        LOGGER.warn("Author with id: {} deleted", id);
        return ResponseEntity.noContent().build();
    }
}