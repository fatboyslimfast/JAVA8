package com.anatwine.shopping.discount;

import com.anatwine.shopping.basket.IBasket;

public interface IDiscount {

	/**
	 * Update the baskets discounts map.
	 *
	 * @param basket
	 *            the current basket
	 * @return total discount amount
	 */
	void applyDiscountRule(IBasket basket);

}