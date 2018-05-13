package com.tumeda.tnote.service.mapper;

import com.tumeda.tnote.domain.Note;
import com.tumeda.tnote.service.dto.NoteDTO;

import java.util.List;
import java.util.Set;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
//
//    Set <E> toEntity(Set<D> dtoSet);
//
//    Set <D> toDto(Set<E> entitySet);

}
