/**
 * 
 */
package com.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
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
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("corejava", "Java 8", "c"),  
			new Topic("hibernate", "Hibernate", "f"), new Topic("springboot", "SpringBoot Starter", "i"))); //makes list mutable
	
	
	public List<Topic> getAllTopics() {
		List<Topic> allTopics = new ArrayList<>();
		
		topicRepository.findAll().forEach(x -> allTopics.add(x));
		 
		// return topics;
		return allTopics;
	}


	public Topic getTopic(String id) {
		
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}


	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}


	public void updateTopic(Topic topic, String id) {
		
		/*for (int i=0; i < topics.size(); i++) {
			
			Topic myTopic = topics.get(i);
			
			if (myTopic.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		} */
		
		topicRepository.save(topic);
		
		
	}


	public void deleteTopic(String id) {
		//topics.removeIf(x -> x.getId().equals(id));
		topicRepository.delete(id);
		
		
	}

}
