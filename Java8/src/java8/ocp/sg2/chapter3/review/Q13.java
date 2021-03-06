package java8.ocp.sg2.chapter3.review;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Q13 {

	public class Wildcard {
		public void showSize(List<?> list) {
			System.out.println(list.size());
		}
	}

	public static void main(String[] args) {
		Wildcard card = new Q13().new Wildcard();

		ArrayDeque<?> list1 = new ArrayDeque<String>();
		ArrayList<? super Date> list2 = new ArrayList<Date>(); // this is valid
		List<?> list3 = new ArrayList<?>(); // DOES NOT COMPILE .. cannot instantiate Arraylist using this syntax
		List<Exception> list4 = new LinkedList<java.io.IOException>();  //DOES NOT COMPILE .. either List<? extends Exception>, List<IOException> or new LinkedList<Exception>
		Vector<? extends Number> list5 = new Vector<Integer>(); // this is valid, Vector implements List


		card.showSize(list1);  // DOES NOT COMPILE .. List is method parameter not a Queue
		card.showSize(list2);
		card.showSize(list3);
		card.showSize(list4);
		card.showSize(list5);

	}

}
