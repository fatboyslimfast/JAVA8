/**
 * 
 */
package com.anatwine.shopping.controller;

import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.view.BasketView;

/**
 * @author Pete
 *
 */
public class MainController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a new Basket
		Basket model = new Basket();
		// Create the view
		BasketView view = new BasketView();
		BasketController controller = new BasketController(model, view);
		controller.processUserEntry();

	}

}
