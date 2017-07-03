package java8.ocp.sg2.chapter3;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<String>();
		strings.add("tweet");

		List<Object> objects = new ArrayList<Object>();
		objects.add("brr");

		addSoundUnBounded(strings);
		addSoundUnBounded(objects);

		addSoundUpperBounded(strings);
		addSoundUpperBounded(objects);

		addSoundObject(strings); // No (with generics, must pass exact match)
		addSoundObject(objects);

		addSoundLowerBounded(strings);
		addSoundLowerBounded(objects);

	}

	public static void addSoundUnBounded(List<?> list) {
		list.add("quack"); // No (unbounded generics are immutable)
	}

	public static void addSoundUpperBounded(List<? extends Object> list) {
		list.add("quack"); // No (upper-bounded generics are immutable)
	}

	public static void addSoundObject(List<Object> list) {
		list.add("quack");
	}

	public static void addSoundLowerBounded(List<? super String> list) {
		/*
		 * With a lower bound, we are telling Java that the list will be a list
		 * of String objects or a list of some objects that are a superclass of
		 * String. Either way, it is safe to add a String to that list.
		 */
		list.add("quack");
	}

}
