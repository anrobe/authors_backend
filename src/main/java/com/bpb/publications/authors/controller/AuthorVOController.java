package com.bpb.publications.authors.controller;

import com.bpb.publications.authors.exception.BadRequestException;
import com.bpb.publications.authors.exception.ResourceNotFoundException;
import com.bpb.publications.authors.vo.AuthorVO;
import com.bpb.publications.authors.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorVOController {

    private final AuthorService authorService;

    public AuthorVOController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorVO>> getAllAuthors() {
        List<AuthorVO> authors = authorService.getAuthors();
        if (authors == null || authors.isEmpty()) {
            throw new ResourceNotFoundException("No authors found");
        }
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<AuthorVO> getAuthorById(@PathVariable Long id) {
        AuthorVO author = authorService.getAuthor(id);
        if (author == null) {
            throw new ResourceNotFoundException("No author found with id: " + id);
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthorVO> createAuthor(@RequestBody AuthorVO authorVO) {
        if (authorVO.getId() != null) {
            throw new BadRequestException("New author cannot have an ID");
        }
        AuthorVO createdAuthor = authorService.addAuthor(authorVO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAuthor.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAuthor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorVO> updateAuthor(@PathVariable Long id, @RequestBody AuthorVO authorVO) {
        if (!id.equals(authorVO.getId())) {
            throw new BadRequestException("ID in path and request body must match");
        }
        AuthorVO updatedAuthor = authorService.updateAuthor(id, authorVO);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}