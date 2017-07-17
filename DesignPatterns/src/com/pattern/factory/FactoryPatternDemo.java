/**
 *
 */
package com.pattern.factory;

/**
 * Factory pattern is one of most used design patterns in Java. This type of
 * design pattern comes under creational pattern as this pattern provides one of
 * the best ways to create an object. In Factory pattern, we create objects
 * without exposing the creation logic to the client and refer to newly created
 * object using a common interface.
 *
 * @author pche0001
 *
 */
public class FactoryPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();
		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		// call draw method of Rectangle
		shape2.draw();
		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");
		// call draw method of circle
		shape3.draw();

	}

}
