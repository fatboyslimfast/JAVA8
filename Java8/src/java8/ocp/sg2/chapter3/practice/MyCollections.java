package java8.ocp.sg2.chapter3.practice;

import java.util.Collection;
import java.util.TreeMap;

public class MyCollections {

	public static void main(String[] args) {
		//Collection<String> c = new ArrayDeque<>();
		
		//Collection<String> c = new TreeSet<>();
		
		Collection<String, String> c = new TreeMap<>();
		
		c.add("Pen");
		
		c.remove("Pen");
		
		System.out.println(c.isEmpty());

	}

}
