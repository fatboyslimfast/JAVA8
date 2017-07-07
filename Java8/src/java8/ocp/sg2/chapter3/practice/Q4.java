package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.TreeSet;

public class Q4 {

	public static void main(String[] args) {
		Collection<String> c = new ArrayDeque<>();
		//Map<String, String> c = new TreeMap<>();
		//c.put("Pen", "Ink")
		Collection<String> d = new TreeSet<>();

		c.add("Pen");
		c.remove("Pen");
		System.out.println(c.isEmpty());


		d.add("Pen");
		d.remove("Pen");
		System.out.println(d.isEmpty());

	}

}
