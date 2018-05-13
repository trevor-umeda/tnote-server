package com.tumeda.tnote.service.impl;

import com.tumeda.tnote.service.TopicService;
import com.tumeda.tnote.domain.Topic;
import com.tumeda.tnote.repository.TopicRepository;
import com.tumeda.tnote.service.dto.TopicDTO;
import com.tumeda.tnote.service.mapper.TopicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Topic.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    private final Logger log = LoggerFactory.getLogger(TopicServiceImpl.class);

    private final TopicRepository topicRepository;

    private final TopicMapper topicMapper;

    public TopicServiceImpl(TopicRepository topicRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.topicMapper = topicMapper;
    }

    /**
     * Save a topic.
     *
     * @param topicDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TopicDTO save(TopicDTO topicDTO) {
        log.debug("Request to save Topic : {}", topicDTO);
        Topic topic = topicMapper.toEntity(topicDTO);
        topic = topicRepository.save(topic);
        return topicMapper.toDto(topic);
    }

    /**
     * Get all the topics.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<TopicDTO> findAll() {
        log.debug("Request to get all Topics");
        return topicRepository.findAll().stream()
            .map(topicMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one topic by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public TopicDTO findOne(Long id) {
        log.debug("Request to get Topic : {}", id);
        Topic topic = topicRepository.findOne(id);
        return topicMapper.toDto(topic);
    }

    @Override
    public List<TopicDTO> findAllByAuthorId(Long authorId) {
        log.debug("Request to get Topic by authorid : {}", authorId);
        List<Topic> topic = topicRepository.findByAuthor_id(authorId);
        List<TopicDTO> topics = topic.stream()
            .map(topicMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));;
        return topics;
    }

    /**
     * Delete the topic by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Topic : {}", id);
        topicRepository.delete(id);
    }
}
