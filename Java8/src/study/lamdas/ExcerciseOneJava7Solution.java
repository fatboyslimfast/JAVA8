package study.lamdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExcerciseOneJava7Solution {

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

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person arg0, Person arg1) {
				return arg0.getLastName().compareTo(arg1.getLastName());
			}

		});

		// Create a method to print all elements

		printAll(people);

		// Create a method all elements with last name beginiing with 'C'
		System.out.println("Printing all people last name starting with 'H'");
		printLastnameConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("H");
			}

		});

		System.out.println("Printing all people first name starting with 'P'");
		printLastnameConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("P");
			}

		});

	}

	private static void printLastnameConditionally(List<Person> people, Condition condition) {
		System.out.println("===============================");
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}

		}

	}

	private static void printAll(List<Person> people) {
		System.out.println("Printing all people");
		for (Person p : people) {
			System.out.println(p);
		}

	}
}

interface Condition {
	boolean test(Person p);
}
