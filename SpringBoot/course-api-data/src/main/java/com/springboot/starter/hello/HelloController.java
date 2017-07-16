/**
 * 
 */
package com.springboot.starter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pete
 *
 */
@RestController
public class HelloController {
	
	// have methods that map to user requests
	@RequestMapping("/hello") //maps to all HTTP Method Request e.g. GET (query), PUT (update), POST (create), DELETE (remove)
	public String sayHi() {
		return "Hi";
	}
	
	

	
	

}
