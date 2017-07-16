/**
 * 
 */
package com.springboot.starter.lesson;

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
	
	
	public List<Course> getAllCourses() {
		List<Course> allCourses = new ArrayList<>();
		
		courseRepository.findAll().forEach(x -> allCourses.add(x));

		return allCourses;
	}


	public Course getCourse(String id) {
		
		return courseRepository.findOne(id);
	}


	public void addCourse(Course topic) {
		courseRepository.save(topic);
		
	}


	public void updateCourse(Course topic, String id) {
		courseRepository.save(topic);
	}


	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
