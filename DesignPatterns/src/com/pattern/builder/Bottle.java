/**
 *
 */
package com.pattern.builder;

/**
 * @author pche0001
 *
 */
public class Bottle implements Packing {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pattern.builder.Packing#pack()
	 */
	@Override
	public String pack() {
		return "Bottle";
	}

}
