package java8.ocp.sg2.chapter3.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q8 {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Grapes of Wrath");
		list.add("1984");

		list.forEach(s -> System.out.println(s));
		list.forEach(System.out::println);


		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
