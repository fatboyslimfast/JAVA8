package java8.ocp.sg2.chapter3.review;

import java.util.TreeSet;

public class Q8 {


	public static void main(String... args){
		TreeSet<String> trees = new TreeSet<String>();
		//trees.add("On");
		trees.add("one");
		trees.add("One");
		trees.add("ONE");// [ONE, One, one]

		for (String tree: trees){
			System.out.println(tree);
		}


		System.out.println(trees.ceiling("On")); //One // smallest element >= e or null no such element


	}




}
