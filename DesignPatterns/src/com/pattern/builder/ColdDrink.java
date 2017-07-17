/**
 *
 */
package com.pattern.builder;

/**
 * @author pche0001
 *
 */
public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();

}
