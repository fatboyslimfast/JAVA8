/**
 * 
 */
package com.springboot.starter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Pete
 *
 */
@Entity
public class Course {
	@Id
	private String id;
	private String name;
	
	
	/**
	 * 
	 */
	public Course() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 */
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
