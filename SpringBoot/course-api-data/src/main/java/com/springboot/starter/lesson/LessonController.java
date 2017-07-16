/**
 * 
 */
package com.springboot.starter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pete
 *
 */
@RestController
public class CourseController {
	
	@Autowired // dependency injection annotation
	private CourseService courseService;
	
	@RequestMapping("/topics") // (method=RequestMethod.GET, value="/topics") is also valid
	public List<Course> getAllCourses() {
		// Spring converts Java values to Json response
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addCourse(@RequestBody Course topic) { // tells Spring request pay load body contains instance of Course
		courseService.addCourse(topic);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateCourse(@RequestBody Course topic, @PathVariable String id) { // tells Spring request pay load body contains instance of Course and Id passed in on path
		courseService.updateCourse(topic, id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteCourse(@PathVariable String id) { // tells Spring Id passed in on path
		courseService.deleteCourse(id);
		
	}

}
