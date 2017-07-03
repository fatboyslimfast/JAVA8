/**
 * 
 */
package java8.ocp.sg2.chapter2.practice;

/**
 * @author Pete
 *
 */
public class Woods {

	
	static class Tree{}
	
	/**
	 * @param args
	 */
	public static void main(String[] leaves) {
		int water = 10+5;
	
		final class Oak extends Tree {
			
			public int getWater() {
				return water;
			}
			
		}
		
		System.out.println(new Oak().getWater());

	}

}
