package com.tumeda.tnote.service;

import com.tumeda.tnote.service.dto.TopicDTO;
import java.util.List;

/**
 * Service Interface for managing Topic.
 */
public interface TopicService {

    /**
     * Save a topic.
     *
     * @param topicDTO the entity to save
     * @return the persisted entity
     */
    TopicDTO save(TopicDTO topicDTO);

    /**
     * Get all the topics.
     *
     * @return the list of entities
     */
    List<TopicDTO> findAll();

    /**
     * Get the "id" topic.
     *
     * @param id the id of the entity
     * @return the entity
     */
    TopicDTO findOne(Long id);

    List<TopicDTO> findAllByAuthorId(Long id);

    /**
     * Delete the "id" topic.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
