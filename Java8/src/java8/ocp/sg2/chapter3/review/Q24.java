package java8.ocp.sg2.chapter3.review;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class Q24 {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("lion");
		s.add("tiger");
		s.add("bear");





		s.forEach(t -> System.out.println(t));


		s.forEach((t) -> System.out.println(t));

		s.forEach(System.out::println);


	//	s.forEach(() -> System.out.println(s)); //DOES NOT COMPILE

	//	s.forEach(System::out::println); //DOES NOT COMPILE


		Supplier<Set<String>> s2 = HashSet::new;
		s2.get().add("Pete");
		s2.get().add("Mark");

		

	}

}
