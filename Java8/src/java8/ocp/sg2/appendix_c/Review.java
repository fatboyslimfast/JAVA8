/**
 * 
 */
package java8.ocp.sg2.appendix_c;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Pete
 *
 */
public class Review {

	
	 int i1 = 1_234;
	 //double d1 = 1_234_.0;
	 //double d2 = 1_234._0;
	 //double d3 = 1_234.0_;
	 double d4 = 1_234.0;
	
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		final char a = 'A', d = 'D'; // p1
		char grade = 'B';
		switch (grade) {
		case a: // p2
		case 'B':
			System.out.print("great");
		case 'C':
			System.out.print("good");
			break;
		case d: // p3
		case 'F':
			System.out.print("not good");
		}

		System.out.println("\n");

		DecimalFormat df = new DecimalFormat("#,000.0#");
		double pi = 3.141592653;
		System.out.println(df.format(pi));

		System.out.println("\n");

		int x = 10 % 2 + 1;
		switch (x) {
		case 0:
			System.out.print(x + " Too High");
			break;
		case 1:
			System.out.print(x + " Just Right");
			break;
		default:
			System.out.print(x + " Too Low");
		}

		System.out.println("\n");

		final int movieRating = 4;
		final int badMovie = 9;
		switch (badMovie) {
		case 0:
		case badMovie:
			System.out.println("Awful");
			break;
		case movieRating:
			System.out.println("Great");
			break;
		// case 4:
		default:
		case (int) 'a':
		case 1 * 1:
			System.out.println("Too be determined");
			break;
		}

		System.out.println("\n");

		NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);
		String value = "444,33";
		System.out.println(nf.parse(value));

		System.out.println("\n");

		Locale.setDefault(Locale.GERMANY);
		DecimalFormat dfDE = new DecimalFormat("#00.00##");
		double pi2 = 3.141592653;
		System.out.println(dfDE.format(pi2));
		
		System.out.println("\n");

		
		int xx = 10;
		switch(xx % 4.0) {
		default: System.out.print("Not divisible by 4");
		case 0: System.out.print("Divisible by 4");
		}

	}

	public void admission() {
		//int amount = 9L;
		int amount2 = 0b101;
		int amount3 = 0xE;
		double amount4 = 0xE;
		//double amount5 = 1_2_.0_0;
		//int amount6 = 1_2_;
		
		// INSERT CODE HERE
		System.out.println(amount2);
	}

}
