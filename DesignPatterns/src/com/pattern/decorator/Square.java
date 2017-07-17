/**
 *
 */
package com.pattern.decorator;

/**
 * @author pche0001
 *
 */
public class Square implements Shape {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.pattern.factory.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");

	}

}
