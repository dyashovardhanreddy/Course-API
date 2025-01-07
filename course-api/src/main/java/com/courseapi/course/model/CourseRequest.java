package com.courseapi.course.model;

public class CourseRequest {
	
	private int courseId;
	private String name;
	private String description;
	private int topicId;
	public CourseRequest(int courseId, String name, String description, int topiId) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.topicId = topiId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTopicId() {
		return topicId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
}
