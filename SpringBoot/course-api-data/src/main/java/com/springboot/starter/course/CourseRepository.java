/**
 * 
 */
package com.springboot.starter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Pete
 *
 */
public interface CourseRepository extends CrudRepository<Course, String> {

	// naming convention
	public List<Course> findByName(String name);
	
	public List<Course> findByDescription(String description);
	
	public List<Course> findByTopicId(String topicId);
	
	
}