package com.tumeda.tnote.service.mapper;

import com.tumeda.tnote.domain.*;
import com.tumeda.tnote.service.dto.TopicDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Topic and its DTO TopicDTO.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class, NoteMapper.class})
public interface TopicMapper extends EntityMapper<TopicDTO, Topic> {

    @Mapping(source = "author.id", target = "authorId")
    TopicDTO toDto(Topic topic);

    @Mapping(source = "authorId", target = "author")
    @Mapping(target = "notes", ignore = true)
    Topic toEntity(TopicDTO topicDTO);

    default Topic fromId(Long id) {
        if (id == null) {
            return null;
        }
        Topic topic = new Topic();
        topic.setId(id);
        return topic;
    }
}
