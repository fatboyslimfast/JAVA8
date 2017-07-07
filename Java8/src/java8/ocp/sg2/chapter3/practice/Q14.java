package java8.ocp.sg2.chapter3.practice;

import java.util.LinkedList;
import java.util.List;

public class Q14 {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("A");
		list.add("B");

		list.stream().forEach(s -> System.out.println(s));
		list.stream().forEach(System.out::println);

	}

}
