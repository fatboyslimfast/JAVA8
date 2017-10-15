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
public class ParallelStreamsExample {

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

		people.parallelStream().filter(p -> p.getLastName().startsWith("H"))
				.forEach(p -> System.out.println(p.getFirstName()));

		long count = people.parallelStream().filter(p -> p.getLastName().startsWith("C")).count(); // count
		// =
		// terminal
		// operation

		System.out.println(count);

	}

}
