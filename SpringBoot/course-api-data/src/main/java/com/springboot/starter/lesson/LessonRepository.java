/**
 * 
 */
package com.springboot.starter.lesson;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Pete
 *
 */
public interface CourseRepository extends CrudRepository<Course, String> {
	
}
