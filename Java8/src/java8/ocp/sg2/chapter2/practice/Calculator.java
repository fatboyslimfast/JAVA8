/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Calculator {
	
	protected void calculate(AddNumbers add, int a, int b) {
		System.out.println(add.add(a, b));
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Calculator ti = new Calculator();
		ti.calculate((k,p) -> p+k+1, 2, 5);

	}

}
