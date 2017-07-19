package com.anatwine.shopping.view;

import com.anatwine.shopping.basket.IBasket;

public interface IBasketView {

	/**
	 * Print Receipt. Sub-total, any Discounts and Grand Total.
	 *
	 * @return String receipt
	 */
	String printReceipt(IBasket basket);

}