package com.example.app.controller;

import com.example.app.dto.TopicDTO;
import com.example.app.service.TopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/topics")
@RestController
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{id}")
    public TopicDTO getTopicById(@PathVariable Integer id) {
        return topicService.getTopic(id);
    }

    @PutMapping("/{id}")
    public void updateTopic(@PathVariable Integer id, @RequestBody TopicDTO topicDTO) {
        topicService.updateTopic(id, topicDTO);
    }
}
