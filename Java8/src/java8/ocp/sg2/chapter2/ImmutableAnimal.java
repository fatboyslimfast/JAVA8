package java8.ocp.sg2.chapter2;

import java.util.ArrayList;
import java.util.List;

//the class itself is marked final, so the methods cannot be overridden by a subclass.
public class ImmutableAnimal {
	// all fields are marked private and final
	// and the constructor sets them upon object creation
	private final String species;
	private final int age;
	// the class does contain a mutable object, List, but no references to the
	// object are publicly
	// available.
	private final List<String> favoriteFoods;

	public ImmutableAnimal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		//when creating immutable objects that any mutable input arguments are copied to the
		//instance instead of being used directly.
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}

	// there are no setter methods

}
