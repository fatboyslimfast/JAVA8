/**
 *
 */
package java8.ocp.sg2.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pche0001
 *
 */
public class SynchronizedCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * if you are given an existing collection that is not a concurrent
		 * class and need to access it among multiple threads, you can wrap it
		 * using the methods in synchronized* methods
		 */
		List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));

		synchronized (list) { // it is imperative that you use a synchronization
								// block if you need to iterate over any of the
								// returned collections
			for (int data : list)
				System.out.print(data + " ");
			list.add(99);
		}

		System.out.println(
				"Unlike the concurrent collections, the synchronized collections also throw an exception if they are modified within an iterator by a single thread.");

		Map<String, Object> foodData = new HashMap<String, Object>();
		foodData.put("penguin", 1);
		foodData.put("flamingo", 2);
		Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
		for (String key : synchronizedFoodData.keySet())
			synchronizedFoodData.remove(key);

	}

}
