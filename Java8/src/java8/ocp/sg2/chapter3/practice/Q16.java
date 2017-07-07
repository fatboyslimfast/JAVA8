package java8.ocp.sg2.chapter3.practice;

import java.util.stream.Stream;

public class Q16 {

	public static void main(String[] args){
		Stream<String> s = Stream.of("Bristol","Manchester", "London", "Birmingham", "Bradford", "Exeter");
		long count = s.filter(c -> c.startsWith("B")).count();
		System.out.println(count);

	}
}
