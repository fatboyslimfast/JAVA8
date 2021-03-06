package java8.ocp.sg2.chapter3.review;

import java.util.ArrayDeque;

public class Q4 {

	public static void main(String[] args) {
		ArrayDeque<String> greetings = new ArrayDeque<String>();
		greetings.push("hello"); // [hello]
		greetings.push("hi"); // [hello, hi]
		greetings.push("ola"); // [hello, hi, ola]
		greetings.pop(); // [hello, hi]
		greetings.peek(); // return hi
		while (greetings.peek() != null)
			System.out.print(greetings.pop()); // hihello
	}

}
