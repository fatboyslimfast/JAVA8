/**
 *
 */
package java8.ocp.sg2.chapter2;

/**
 * @author pche0001
 *
 */
public class FindMatchingAnimals2 {

	private static void print(Animal animal, Predicate<Animal> trait) {
		if (trait.test(animal))
			System.out.println(animal);
	}

	public static void main(String[] args) {
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
	}

}
