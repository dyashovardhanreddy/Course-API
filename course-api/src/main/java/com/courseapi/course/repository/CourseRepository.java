package com.courseapi.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.courseapi.course.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{

	 List<Course> findByTopicId(int topicId);

	    // Fetch a specific course by topicId and courseId
	 Optional<Course> findByTopicIdAndId(int topicId, int courseId);
}
