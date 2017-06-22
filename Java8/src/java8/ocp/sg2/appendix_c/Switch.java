package java8.ocp.sg2.appendix_c;

import java.time.Month;

/**
 * @author pche0001
 *
 */
public class Switch {

	/*
	 * Data types supported by switch statements include the following: ■■ int
	 * and Integer ■■ byte and Byte ■■ short and Short ■■ char and Character ■■
	 * String ■■ enum values
	 */

	public static void main(String... args) {

		exampleOne();
		exampleTwo();
		exampleThree();

	}

	private int getSortOrder(String firstName, final String lastName) {
		String middleName = "Patricia";
		final String suffix = "JR";
		int id = 0;
		switch (firstName) {
		case "Test":
			return 52;
		case middleName: // DOES NOT COMPILE ... case expressions must be constant expressions
			id = 5;
			break;
		case suffix:
			id = 0;
			break;
		case lastName: // DOES NOT COMPILE .. case expressions must be constant expressions
			id = 8;
			break;
		case 5: // DOES NOT COMPILE .. Type mismatch: cannot convert from int to String
			id = 7;
			break;
		case 'J': // DOES NOT COMPILE .. Type mismatch: cannot convert from char to String
			id = 10;
			break;
		case Month.JANUARY: // DOES NOT COMPILE .. Type mismatch: cannot convert from Month to String
			id = 15;
			break;
		}
		return id;
	}

	private static void exampleThree() {

		/*
		 * if the value of dayOfWeek was 0, all three statements would be
		 * output:
		 */

		System.out.println("exampleThree");
		int dayOfWeek = 0;
		switch (dayOfWeek) {
		case 0_0:
			System.out.println("Sunday");
		default:
			System.out.println("Weekday");
		case 6:
			System.out.println("Saturday");
		}
	}

	private static void exampleTwo() {

		/*
		 * This means that if dayOfWeek is 5, then the code will jump to the
		 * default block and then execute all of the proceeding case statements
		 * in order until it finds a break statement or finishes the structure
		 */

		System.out.println("exampleTwo");
		int dayOfWeek = 5;
		switch (dayOfWeek) {
		case 0_0:
			System.out.println("Sunday");
		default:
			System.out.println("Weekday");
		case 6:
			System.out.println("Saturday");
		}
	}

	private static void exampleOne() {
		System.out.println("exampleOne");
		int dayOfWeek = 5;
		switch (dayOfWeek) {
		default:
			System.out.println("Weekday");
			break;
		case 0_0:
			System.out.println("Sunday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		}
	}

}
