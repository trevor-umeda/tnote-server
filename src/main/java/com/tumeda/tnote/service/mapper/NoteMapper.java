package com.tumeda.tnote.service.mapper;

import com.tumeda.tnote.domain.*;
import com.tumeda.tnote.service.dto.NoteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Note and its DTO NoteDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface NoteMapper extends EntityMapper<NoteDTO, Note> {

    @Mapping(source = "note.id", target = "noteId")
    NoteDTO toDto(Note note);

    @Mapping(source = "noteId", target = "note")
    @Mapping(target = "children", ignore = true)
    Note toEntity(NoteDTO noteDTO);

    default Note fromId(Long id) {
        if (id == null) {
            return null;
        }
        Note note = new Note();
        note.setId(id);
        return note;
    }
}
