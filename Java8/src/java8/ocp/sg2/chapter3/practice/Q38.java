package java8.ocp.sg2.chapter3.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Q38 {
	
	class Wash<T extends Collection> {
		T item;
		public void clean(T items){
			System.out.println("Cleaned " + items.size() + " items"); // size method on List
		}
	}
	
	public static void main(String[] args) {
		Wash<List> wash = new Q38().new Wash<List>();
		wash.clean(Arrays.asList("sock", "tie"));
	}
	

}
