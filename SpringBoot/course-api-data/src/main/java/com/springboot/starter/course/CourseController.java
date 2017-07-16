/**
 * 
 */
package com.springboot.starter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.starter.topic.Topic;

/**
 * @author Pete
 *
 */
@RestController
public class CourseController {
	
	@Autowired // dependency injection annotation
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses") // (method=RequestMethod.GET, value="/courses") is also valid
	public List<Course> getAllCourses(@PathVariable String topicId) {
		// Spring converts Java values to Json response
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) { // tells Spring request pay load body contains instance of Course
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId,  @PathVariable String id) { // tells Spring request pay load body contains instance of Course and Id passed in on path
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) { // tells Spring Ids are passed in on path
		courseService.deleteCourse(id);
		
	}

}
