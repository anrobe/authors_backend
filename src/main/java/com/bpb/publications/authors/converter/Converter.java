package com.bpb.publications.authors.converter;

import com.bpb.publications.authors.entity.Author;
import com.bpb.publications.authors.vo.AuthorVO;

public interface Converter {
    AuthorVO convertToVO(Author author);
    Author convertToEntity(AuthorVO authorVO);
}
