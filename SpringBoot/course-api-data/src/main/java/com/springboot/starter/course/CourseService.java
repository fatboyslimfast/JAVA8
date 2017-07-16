/**
 * 
 */
package com.springboot.starter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Typically services are a singleton,Spring will create and inject. 
 * @Service marks this as a Spring Business service
 * 
 * 
 * @author Pete
 *
 */
@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> allCourses = new ArrayList<>();
		
		allCourses = courseRepository.findByTopicId(topicId);

		return allCourses;
	}


	public Course getCourse(String id) {
		
		return courseRepository.findOne(id);
	}


	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}


	public void updateCourse(Course course) {
		courseRepository.save(course);
	}


	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
