package java8.ocp.sg2.chapter3.review;

import java.io.FileNotFoundException;

public class Q12 {

	public static class Helper {
		public static <U extends Exception> void printException(U u) {
			System.out.println(u.getMessage());
		}
	}

	public static void main(String[] args) {
		Helper.printException(new FileNotFoundException("A"));
		Helper.printException(new Exception("B"));
		Helper.<Throwable>printException(new Exception("C")); // change Throwable to Exception
		Helper.<NullPointerException>printException(new NullPointerException("D"));
		Helper.printException(new Throwable("E")); // argument not applicable

	}

}
