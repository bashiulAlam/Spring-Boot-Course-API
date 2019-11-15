package com.sample.controller;

import com.sample.repository.Topic;
import com.sample.repository.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sabab on 10/7/2019.
 */

@RestController
public class TopicController {

    private static Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        logger.info("Getting all topics...");
        return topicService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id) {
        logger.info("Getting all topics by id : {id}", id);
        return topicService.getTopicById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic) {
        logger.info("Adding a new topic...");
        logger.debug("Request Body : " + topic.toString());
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }
}
