/**
 * 
 */
package java8.ocp.sg2.chapter1;

import java8.ocp.sg2.chapter1.cat.BigCat;

/**
 * @author Pete
 *
 */
public class Modifiers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		System.out.println(cat.id);

	}

}
