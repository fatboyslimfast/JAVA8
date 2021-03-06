/**
 *
 */
package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author pche0001
 *
 */
public class Duck implements Comparable<Duck> {
	private String name;
	private int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Duck d) { // compareTo ... Comparable, 1 parameter
		return name.compareTo(d.name);
	}

	public class ChainingComparator implements Comparator<Duck> {
		public int compare(Duck s1, Duck s2) {
			Comparator<Duck> c = Comparator.comparing(s -> s.getName());
			c = c.thenComparingInt(s -> s.getWeight());
			return c.compare(s1, s2);
		}
	}

	public static void main(String[] args) {
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			public int compare(Duck d1, Duck d2) { // compare .... Comparator, 2
													// parameters
				return d1.getWeight() - d2.getWeight(); // ascending weight
			}
		};

		// Comparator is a functional interface
		byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight();
		byWeight = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight();
		byWeight = (d1, d2) -> {
			return d1.getWeight() - d2.getWeight();
		};
		byWeight = (Duck d1, Duck d2) -> {
			return d1.getWeight() - d2.getWeight();
		};

		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack", 7));
		ducks.add(new Duck("Puddles", 10));
		Collections.sort(ducks);
		System.out.println(ducks); // [Puddles, Quack]
		Collections.sort(ducks, byWeight);
		System.out.println(ducks); // [Quack, Puddles]
	}

}
