/**
 *
 */
package com.pattern.builder;

/**
 * @author pche0001
 *
 */
public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();

}
