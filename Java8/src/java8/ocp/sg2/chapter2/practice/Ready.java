/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Ready {
	
	protected static int first = 2;
	
	private final short DEFAULT_VALUE = 10;
	
	private static class GetSet {
		int first = 5;
		
		static int second = DEFAULT_VALUE;
	}
	
	private GetSet go = new GetSet();
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ready r = new Ready();
		System.out.print(r.go.first);
		System.out.print(", "+r.go.second);		 
		
		

	}

}
