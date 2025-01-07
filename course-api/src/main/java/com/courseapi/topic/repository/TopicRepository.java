package com.courseapi.topic.repository;

import org.springframework.data.repository.CrudRepository;

import com.courseapi.topic.model.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
