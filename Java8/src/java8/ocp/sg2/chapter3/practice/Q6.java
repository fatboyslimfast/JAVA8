package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q6 {

	public class JellyBean {
	}

	public static void main(String[] args) {

		JellyBean jellyBean = new Q6().new JellyBean();

		List<JellyBean> list = new ArrayList<>();
		System.out.println("Adding to ArrayList");

		list.add(jellyBean);
		list.add(null);
		list.add(null);
		list.add(jellyBean);
		System.out.println(list);

		Queue<JellyBean> queue = new ArrayDeque<>();
		System.out.println("Adding to ArrayDeque");
		queue.add(jellyBean);
		queue.add(jellyBean); // can add duplicates
		// queue.add(null); //cannot add null
		System.out.println(queue);

		Map<JellyBean, JellyBean> hashMap = new HashMap<>();
		System.out.println("Adding to HashMap");
		hashMap.put(jellyBean, jellyBean);
		hashMap.put(jellyBean, jellyBean);
		hashMap.put(jellyBean, null);
		hashMap.put(null, jellyBean);
		hashMap.put(null, jellyBean);
		System.out.println(hashMap);

		Set<JellyBean> hashSet = new HashSet<>();
		System.out.println("Adding to HashSet");
		hashSet.add(jellyBean);
		hashSet.add(jellyBean);
		hashSet.add(null);
		hashSet.add(null);
		System.out.println(hashSet);

		Map<JellyBean, JellyBean> treeMap = new TreeMap<>();
		try {
			System.out.println("Adding to HashMap");
			treeMap.put(jellyBean, jellyBean);
		} catch (ClassCastException ex) {
			System.out.println("Cannot add to treeMap" + ex);
		}

		Set<JellyBean> treeSet = new TreeSet<>();

		try {
			System.out.println("Adding to TreeSet");
			treeSet.add(jellyBean);
		} catch (ClassCastException ex) {
			System.out.println("Cannot add to treeSet" + ex);
		}

	}

}
