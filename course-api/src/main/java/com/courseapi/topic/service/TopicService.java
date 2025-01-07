package com.courseapi.topic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courseapi.topic.model.Topic;
import com.courseapi.topic.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
	
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(int id) {
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public ResponseEntity<String> deleteTopic(int id) {
		if(topicRepository.existsById(id)) {
			topicRepository.deleteById(id);
			return new ResponseEntity<>("Topic deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No topic found with Id:" + id, HttpStatus.NOT_FOUND);
		}
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}
}
