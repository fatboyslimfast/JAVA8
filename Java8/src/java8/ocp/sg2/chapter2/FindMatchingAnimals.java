/**
 *
 */
package java8.ocp.sg2.chapter2;

import java.util.Arrays;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class FindMatchingAnimals {

	private static void print(Animal animal, CheckTrait trait) {
		if (trait.test(animal)) {
			System.out.println(animal);
		}
	}

	public static void main(String[] args) {

		/*We specify a single parameter with the name a .
		■ The arrow operator -> separates the parameter from the body.
		■ The body calls a single method and returns the result of that method.
		*/

		//Lambda syntax omitting optional parts
		print(new Animal("fish", false, true), a -> a.canSwim());

		//Lambda syntax, including optional parts
		print(new Animal("frog", true, true), (Animal a) -> {return a.canHop();});

		print(new Animal("kangaroo", true, false), a -> a.canHop());

		// required parenthesis
	//	print(new Animal("kangaroo", true, false), Animal a -> a.canHop()); // DOES NOT COMPILE
	//	print(new Animal("kangaroo", true, false), a1  -> a1.canHop()); // DOES NOT COMPILE
	//	print(new Animal(Animal a, Duck d -> d.quack()); // DOES NOT COMPILE


		String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
		List<String> players =  Arrays.asList(atp);

	/*	// Old looping
		for (String player : players) {
		     System.out.print(player + "; ");
		}
*/
		// Using lambda expression and functional operations
		players.forEach((player) -> System.out.print(player + "; "));

		players.forEach((player) -> System.out.print("\n"));

		players.forEach((player) -> {System.out.print(player.startsWith("R"));});

		// Using double colon operator in Java 8
	//	players.forEach(System.out::println);



	}

}
