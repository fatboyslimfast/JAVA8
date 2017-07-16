/**
 * 
 */
package com.springboot.starter.topic;

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
public class TopicController {
	
	@Autowired // dependency injection annotation
	private TopicService topicService;
	
	@RequestMapping("/topics") // (method=RequestMethod.GET, value="/topics") is also valid
	public List<Topic> getAllTopics() {
		// Spring converts Java values to Json response
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) { // tells Spring request pay load body contains instance of Topic
		topicService.addTopic(topic);
		
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) { // tells Spring request pay load body contains instance of Topic and Id passed in on path
		topicService.updateTopic(topic, id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) { // tells Spring Id passed in on path
		topicService.deleteTopic(id);
		
	}

}
