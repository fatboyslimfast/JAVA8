package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyComparator {

	
	static final String[] names = {"Benjamin", "Paul", "David",  "Pete", "Mark", "Jeremy", "Amar"};
	
	public static void main(String[] args) {
		
		List<String> myNames = new ArrayList<String>(Arrays.asList(names));
		
		Comparator<String> myComparator = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.length() - s1.length();
			}
		};
		myNames.sort(myComparator );
		
		
		for (String name : myNames) {
			System.out.println(name);
		}
		
		
		

	}

}
