package com.bpb.publications.authors.converter.impl;

import com.bpb.publications.authors.converter.Converter;
import com.bpb.publications.authors.entity.Author;
import com.bpb.publications.authors.vo.AuthorVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConverterImpl implements Converter {

    @Override
    public AuthorVO convertToVO(Author author) {
        AuthorVO authorVO = new AuthorVO();
        BeanUtils.copyProperties(author, authorVO);
        return authorVO;
    }

    @Override
    public Author convertToEntity(AuthorVO authorVO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorVO, author);
        return author;
    }
}
