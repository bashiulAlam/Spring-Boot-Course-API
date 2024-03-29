package com.sample.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sabab on 10/9/2019.
 */

@Service
public class TopicService {

    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
            new Topic("1", "CSE 101", "Intro to CSE"),
            new Topic("2", "CSE 201", "C Programming"),
            new Topic("3", "CSE 223", "OOP")
    ));

    public List<Topic> getAllTopic() {
        return topicList;
    }

    public Topic getTopicById(String id) {
        return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topicList.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (Topic topicItem : topicList) {
            if (topicItem.getId().equals(id)) {
                topicList.set(topicList.indexOf(topicItem), topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topicList.removeIf(t -> t.getId().equals(id));
    }
}
