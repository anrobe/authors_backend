package com.bpb.publications.authors.service.impl;

import com.bpb.publications.authors.converter.Converter;
import com.bpb.publications.authors.exception.ResourceNotFoundException;
import com.bpb.publications.authors.repository.AuthorRepository;
import com.bpb.publications.authors.service.AuthorService;
import com.bpb.publications.authors.vo.AuthorVO;
import com.bpb.publications.authors.entity.Author;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final Converter converter;

    public AuthorServiceImpl(AuthorRepository authorRepository, Converter converter) {
        this.authorRepository = authorRepository;
        this.converter = converter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuthorVO> getAuthors() {
        return authorRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(converter::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AuthorVO getAuthor(Long id) {
        return authorRepository.findById(id)
                .map(converter::convertToVO)
                .orElseThrow(() -> new ResourceNotFoundException("No author found with ID: " + id));
    }

    @Override
    @Transactional
    public AuthorVO addAuthor(AuthorVO authorVO) {
        Author author = converter.convertToEntity(authorVO);
        Author savedAuthor = authorRepository.save(author);
        return converter.convertToVO(savedAuthor);
    }

    @Override
    @Transactional
    public AuthorVO updateAuthor(Long id, AuthorVO authorVO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No author found with ID: " + id));
        BeanUtils.copyProperties(authorVO, author);
        Author updatedAuthor = authorRepository.save(author);
        return converter.convertToVO(updatedAuthor);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("No author found with ID: " + id);
        }
        authorRepository.deleteById(id);
    }
}
