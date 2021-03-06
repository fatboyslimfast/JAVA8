package java8.ocp.sg2.chapter3;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetInterfaceExamples {

	public static void main(String[] args) {

		System.out.println("HashSet Example");

		Set<Integer> set = new HashSet<>();
		boolean b1 = set.add(66); // true
		boolean b2 = set.add(10); // true
		boolean b3 = set.add(66); // false
		boolean b4 = set.add(8); // true
		for (Integer integer : set)
			System.out.print(integer + ","); // 66,8,10, not to be sorted order,
												// or the order in which we
												// added the elements

		System.out.println();

		System.out.println("TreeSet Example");

		set = new TreeSet<>();
		b1 = set.add(66); // true
		b2 = set.add(10); // true
		b3 = set.add(66); // false
		b4 = set.add(8); // true
		for (Integer integer : set)
			System.out.print(integer + ","); // 66,8,10, printed out in their
												// natural sorted order

		System.out.println();

		System.out.println("NavigableSet Example");

		NavigableSet<Integer> set2 = new TreeSet<>();
		for (int i = 1; i <= 20; i++)
			set2.add(i);
		System.out.println(set2.lower(10)); // 9 Returns greatest element that
											// is < e, or null if no such
											// element
		System.out.println(set2.floor(10)); // 10 Returns greatest element that
											// is <= e, or null if no such
											// element
		System.out.println(set2.ceiling(20)); // 20 Returns smallest element
												// that is >= e, or null if no
												// such element
		System.out.println(set2.higher(20)); // null Returns smallest element
												// that is > e, or null if no
												// such element

		System.out.println();

		System.out.println("ArrayDeque Example");

		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10)); // true ... Adds an element to the
												// back of the queue and returns
												// whether successful
		System.out.println(queue.offer(4)); // true
		System.out.println(queue.peek()); // 10 Returns next element or returns
											// null if empty queue
		System.out.println(queue.poll()); // 10 Removes and returns next element
											// or returns null if empty queue
		System.out.println(queue.poll()); // 4
		System.out.println(queue.peek()); // null

		// Except for push, all are in the Queue interface as well. push is what
		// makes it a double ended queue.

		// queue.push(Integer.valueOf(12)); // Adds an element to the front of
		// the queue
		// queue.push(Integer.valueOf(13));

		for (Integer integer : queue)
			System.out.print(integer + ",");

		System.out.println();

		System.out.println("Stack Example");

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);
		System.out.println(stack.peek()); // 4
		System.out.println(stack.poll()); // 4
		System.out.println(stack.poll()); // 10
		System.out.println(stack.peek()); // null

		/*
		 * To review, a queue is like a line of people. You get on in the back
		 * and off in the front. A stack is like a stack of plates. You put the
		 * plate on the top and take it off the top.
		 */

		System.out.println();

		System.out.println("HashMap Example");

		Map<String, String> map = new HashMap<>();
		map.put("koala", "bamboo"); // Adds or replaces key/value pair. Returns previous value or null.
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo ... Returns the value mapped by key or null if none is mapped.
		for (String key : map.keySet()) // Returns set of all keys.
			System.out.print(key + ","); // koala,giraffe,lion,


		System.out.println();
		System.out.println("TreeMap Example");

		map = new TreeMap<>();
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String koalaFood = map.get("koala"); // bamboo
		for (String key: map.keySet())
		System.out.print(key + ","); // giraffe,koala,lion, (key order)

		System.out.println();

		for (String keyValue: map.values())
		System.out.print(keyValue + ","); // leaf,bamboo,meat, (key order)


		System.out.println(map.contains("lion")); // DOES NOT COMPILE ... contains() is a method on the Collection interface but not the Map interface.
		System.out.println(map.containsKey("lion")); // true
		System.out.println(map.containsValue("lion")); // false
		System.out.println(map.size()); // 3






	}

}
