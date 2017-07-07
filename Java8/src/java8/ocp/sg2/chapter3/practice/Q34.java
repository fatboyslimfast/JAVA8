package java8.ocp.sg2.chapter3.practice;

import java.util.Set;
import java.util.TreeSet;

public class Q34 {

	class Magazine implements Comparable<Magazine> {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Magazine(String name) {
			this.name = name;
		}

		public int compareTo(Magazine m) {
			return name.compareTo(m.getName());
		}

		public String toString() {
			return name;
		}

	}

	public static void main(String[] args) {

		Set<Magazine> set = new TreeSet<>();
		set.add(new Q34().new Magazine("highlights"));
		set.add(new Q34().new Magazine("Newsweek"));
		set.add(new Q34().new Magazine("highlights")); // duplicate .. won't add

		System.out.println(set.iterator().next()); // Newsweek

	}
}
