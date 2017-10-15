/**
 * 
 */
package study.lamdas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pete
 *
 */
public class CollectionIterationExample {

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
		// external iterators ...

		System.out.println("================ for loop");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}

		System.out.println("================ for in loop");

		for (Person p : people) {
			System.out.println(p);
		}

		// internal iterators ...

		System.out.println("================ lambda for each loop");

		people.forEach(p -> System.out.println(p));

		System.out.println("================ lambda for each loop method ref");

		people.forEach(System.out::println);

	}

}
