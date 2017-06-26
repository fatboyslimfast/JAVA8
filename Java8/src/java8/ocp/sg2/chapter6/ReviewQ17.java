/**
 * 
 */
package java8.ocp.sg2.chapter6;

/**
 * @author Pete
 *
 */
public class ReviewQ17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(MyAutoCloseable my = new MyAutoCloseable(); MyAutoCloseable my2 = new MyAutoCloseable();){
			// do stuff
			System.out.println("ONE ");
		}
		
		try(MyCloseable my = new MyCloseable(); MyCloseable my2 = new MyCloseable();){
			// do stuff
			System.out.println("TWO ");
		}

	}

}
