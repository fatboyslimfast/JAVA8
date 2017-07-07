/**
 * 
 */
package java8.ocp.sg2.chapter3.practice;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pete
 *
 */
public class Q35 {
	
	class Blankie {
		String color;
		String getColor() {
			return color;
		}
		Boolean isPink() {
			return color.equalsIgnoreCase("PINK"); 
		}
	}
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Blankie b1 = new Q35().new Blankie();
		Blankie b2 = new Q35().new Blankie();
		
		b1.color = "pink";
		b2.color = "blue";
		
		List<Blankie> list = Arrays.asList(b1, b2);
		
		list.stream().filter(Q35.Blankie::getColor).forEach(System.out::println); // filter from later requires boolean returned from lambda
		
		//list.stream().filter(Q35.Blankie::isPink).forEach(s -> System.out.println(s.getColor()));
		
		

	}

}
