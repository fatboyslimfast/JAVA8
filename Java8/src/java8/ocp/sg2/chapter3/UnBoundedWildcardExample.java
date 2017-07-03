package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.List;

public class UnBoundedWildcardExample {

	public static void main(String[] args) {
		List<String> keywords = new ArrayList<>();

		keywords.add("Java");
		keywords.add("C++");

		printList(keywords);

	}

	private static void printList(List<?> keywords) { //
		/*
		 * printList() takes any type of list as a parameter. keywords is of
		 * type List<String>. We have a match! List<String> is a list of
		 * anything. “Anything” just happens to be a String here.
		 */
		for (Object o : keywords) {
			System.out.println(o);
		}

	}

}
