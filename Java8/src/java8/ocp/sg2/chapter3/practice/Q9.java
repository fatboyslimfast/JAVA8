package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q9 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(56);
		list.add(56);
		list.add(56);
		list.add(56);
		list.add(3);
		list.add(56);

		Set<Integer> set = new TreeSet<>(list); // duplicates removed, natural ordering [3, 56]
		System.out.print(set.size()); // 2
		System.out.print(" ");
		System.out.print(set.iterator().next()); // 3, the next element in the iteration




	}

}
