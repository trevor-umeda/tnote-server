package com.tumeda.tnote.service.mapper;

import com.tumeda.tnote.domain.*;
import com.tumeda.tnote.service.dto.AuthorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Author and its DTO AuthorDTO.
 */
@Mapper(componentModel = "spring", uses = {TopicMapper.class})
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {

    Author toEntity(AuthorDTO authorDTO);
    AuthorDTO toDto(Author author);

    default Author fromId(Long id) {
        if (id == null) {
            return null;
        }
        Author author = new Author();
        author.setId(id);
        return author;
    }
}
