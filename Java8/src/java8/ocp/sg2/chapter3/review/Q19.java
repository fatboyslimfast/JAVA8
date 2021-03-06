package java8.ocp.sg2.chapter3.review;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q19 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.remove(1); // << removes Object (not found) return false
		System.out.print(q); // [10, 12]
		System.out.println();

		List<Integer> l = new LinkedList<>();
		l.add(10);
		l.add(12);
		l.remove(1); // << removes Object at index
		System.out.print(l); // [10]

	}

}
