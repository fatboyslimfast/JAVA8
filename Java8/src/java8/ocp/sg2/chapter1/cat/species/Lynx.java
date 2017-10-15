package java8.ocp.sg2.chapter1.cat.species;

import java8.ocp.sg2.chapter1.cat.BigCat;

public class Lynx extends BigCat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lynx lynx = new Lynx();
		System.out.println(lynx.name);
		System.out.println(lynx.hasFur);
		System.out.println(lynx.hasPaws);
		System.out.println(lynx.id);

	}

}