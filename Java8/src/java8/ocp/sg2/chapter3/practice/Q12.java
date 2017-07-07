package java8.ocp.sg2.chapter3.practice;

import java.util.Set;
import java.util.TreeSet;

public class Q12 {

	class Magazine //implements Comparable<Magazine>
	{
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
		set.add(new Q12().new Magazine("Razzle"));
		set.add(new Q12().new Magazine("Juggs"));
		set.add(new Q12().new Magazine("Playboy"));

		for (Magazine m : set){
			System.out.println(m.getName());
		}



	}

}
