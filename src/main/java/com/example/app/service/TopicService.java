package com.example.app.service;

import com.example.app.dto.TopicDTO;
import com.example.app.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;


@Service
public class TopicService {

    private static final Logger logger = LoggerFactory.getLogger(TopicService.class);

    @PersistenceContext
    private EntityManager entityManager;

    public TopicDTO getTopic(Integer topicId) {
        Topic topic = entityManager.find(Topic.class, topicId);
        if (topic == null) {
            throw new EntityNotFoundException("Entity not found");
        }
        return topic.toDTO();
    }

    @Transactional
    public void updateTopic(Integer topicId, TopicDTO updated) {
        logger.info(">>>> Entering in the update");
        Topic topic = entityManager.find(Topic.class, topicId);
        if (topic != null) {
            topic.setName(updated.getName());
        } else {
            throw new EntityNotFoundException("Entity not found");
        }
        logger.info(">>>> Leaving the update");
    }
}
