package com.courseapi.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courseapi.course.model.Course;
import com.courseapi.course.model.CourseRequest;
import com.courseapi.course.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/courses")
	public ResponseEntity<String> addCourse(@RequestBody CourseRequest courseRequest) {
		return courseService.addCourse(courseRequest);
	}
	
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getCoursesByTopicId(@PathVariable int topicId){
		return courseService.getCourseByTopicId(topicId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseByTopicIdAndCourseId(@PathVariable int topicId, @PathVariable int courseId) {
		return courseService.getCourseByTopicIdAndCourseId(topicId, courseId);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<String> deleteCourseById(@PathVariable int courseId) {
		return courseService.deleteCourse(courseId);
	}
	
	@PutMapping("/courses/{courseId}")
	public ResponseEntity<String> updateCourse(@RequestBody CourseRequest courseRequest) {
		return courseService.updateCourse(courseRequest);
	}
}
