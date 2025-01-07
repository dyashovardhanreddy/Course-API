package com.courseapi.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.courseapi.course.repository.CourseRepository;
import com.courseapi.topic.model.Topic;
import com.courseapi.topic.repository.TopicRepository;
import com.courseapi.topic.service.TopicService;
import com.courseapi.course.model.*;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Course> getAllCourses(){
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	public List<Course> getCourseByTopicId(int topicId){
		return courseRepository.findByTopicId(topicId);
	}
	
	public Course getCourseByTopicIdAndCourseId(int topicId, int courseId) {
		return courseRepository.findByTopicIdAndId(topicId, courseId).get();
	}
	
	public ResponseEntity<String> addCourse(CourseRequest courseRequest) {
		
		if(topicRepository.existsById(courseRequest.getTopicId())) {
			Topic topic = topicService.getTopic(courseRequest.getTopicId());
			
			Course course = new Course();
			
			course.setDescription(courseRequest.getDescription());
			course.setName(courseRequest.getName());
			course.setTopic(topic);
			
			courseRepository.save(course);
			return new ResponseEntity<>("Course added successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No topic exist with id:" + courseRequest.getTopicId(), HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> deleteCourse(int courseId) {
		if(courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
			return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No course found with Id:" + courseId, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<String> updateCourse(CourseRequest courseRequest) {
	
		if(topicRepository.existsById(courseRequest.getTopicId())) {
			Course course = new Course();
			course.setId(courseRequest.getCourseId());
			course.setName(courseRequest.getName());
			course.setDescription(courseRequest.getDescription());
			course.setTopic(topicService.getTopic(courseRequest.getTopicId()));
			
			courseRepository.save(course);
			return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No topic exist with id:" + courseRequest.getTopicId(), HttpStatus.NOT_FOUND);
		}
	}
}
