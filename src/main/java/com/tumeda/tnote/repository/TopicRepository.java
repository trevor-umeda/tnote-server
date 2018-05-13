package com.tumeda.tnote.repository;

import com.tumeda.tnote.domain.Topic;
import com.tumeda.tnote.service.dto.TopicDTO;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the Topic entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findByAuthor_id(Long authorId);
}
