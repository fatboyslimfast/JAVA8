/**
 * 
 */
package com.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pete
 *
 */
@SpringBootApplication
public class CourseApiApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// start this app
		// create a servlet container
		// host this app in the container
		SpringApplication.run(CourseApiApp.class, args);
		
		
		

	}

}
