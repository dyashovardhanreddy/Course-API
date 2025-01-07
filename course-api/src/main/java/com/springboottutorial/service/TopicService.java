package com.springboottutorial.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboottutorial.model.Topic;

@Service
public class TopicService {

		private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Spring","Spring Boot","Spring Boot Tutorial"),
				new Topic("ORM","Hibernate","ORM Tutorials"),
				new Topic("CSS","CSS","Front-end technologies"),
				new Topic("AWS","AWS","Cloud Technology")));
		
		public List<Topic> getAllTopics(){
			return this.topics;
		}
		
		public Topic getTopic(String id) {
			return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();	
		}
		
		public void addTopic(Topic topic) {
			this.topics.add(topic);
		}
		
		public void deleteTopic(String id) {
			this.topics.removeIf(t -> t.getId().equals(id));
		}
		
		public void updateTopic(Topic topic, String id) {
			for(int i=0;i<topics.size();i++) {
				Topic t = topics.get(i);
				if(t.getId().equals(id)) {
					topics.set(i, topic);
					return;
				}
			}
		}
}
