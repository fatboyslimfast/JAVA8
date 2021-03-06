package java8.ocp.sg2.chapter3.review;

import java.util.Comparator;
import java.util.TreeSet;

public class Q14 {

	public class Sorted implements Comparable<Sorted>, Comparator<Sorted> {

		private int num;
		private String text;

		Sorted(int n, String t) {
			this.num = n;
			this.text = t;
		}

		@Override
		public int compare(Sorted s1, Sorted s2) { // Comparator method
			return s1.num - s2.num;
		}

		@Override
		public int compareTo(Sorted s) { // Comparable method
			return text.compareTo(s.text);
		}

		public String toString() {
			return "" + num;
		}

	}

	public static void main(String[] args) {
		Sorted s1 = new Q14().new Sorted(88, "a");
		Sorted s2 = new Q14().new Sorted(55, "b");
		TreeSet<Sorted> t1 = new TreeSet<>(); //uses Comparable compareTo to sort i.e. text
		t1.add(s1);
		t1.add(s2);
		TreeSet<Sorted> t2 = new TreeSet<>(s1); // passed Comparator to instantiate .. so uses compare i.e. num
		t2.add(s1);
		t2.add(s2);
		System.out.println(t1 + " " + t2);
	}
}
