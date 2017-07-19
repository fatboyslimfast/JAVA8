/**
 * 
 */
package com.anatwine.shopping.controller;

import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.basket.IBasket;
import com.anatwine.shopping.view.BasketView;
import com.anatwine.shopping.view.IBasketView;

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
		IBasket model = new Basket();
		// Create the view
		IBasketView view = new BasketView();
		BasketController controller = new BasketController(model, view);
		controller.processUserEntry();

	}

}
