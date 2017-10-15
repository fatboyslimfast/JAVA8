package study.lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ExcerciseOneJava8SolutionWithPredicate {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> people = new ArrayList<>();
		people.add(new Person("Pete", "Cheung", 47));
		people.add(new Person("Mark", "Hepden", 45));
		people.add(new Person("Matt", "Reis", 48));
		people.add(new Person("Amar", "Sharma", 36));
		people.add(new Person("Nancy", "Humphries", 47));

		// Sort by last name

		Collections.sort(people, (Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Create a method to print all elements

		printConditionally(people, p -> true);

		// Create a method all elements with last name beginning with 'C'
		System.out.println("Printing all people last name starting with 'H'");
		printConditionally(people, p -> p.getLastName().startsWith("H"));

		System.out.println("Printing all people first name starting with 'P'");
		printConditionally(people, p -> p.getFirstName().startsWith("P"));

	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		System.out.println("===============================");
		for (Person p : people) {
			if (predicate.test(p)) {
				System.out.println(p);
			}

		}

	}

}
