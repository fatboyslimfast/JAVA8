package com.anatwine.shopping.basket;

import java.math.BigDecimal;
import java.util.Map;

import com.anatwine.shopping.discount.IDiscount;

public interface IBasket {

	/**
	 * Set basket sub total.
	 *
	 * @param subTotal
	 *            amount
	 */
	void setSubTotal(BigDecimal subTotal);

	/**
	 * @return the sub total.
	 */
	BigDecimal getSubTotal();

	/**
	 * @return the discount total.
	 */
	BigDecimal getDiscountTotal();

	/**
	 * The basket map, {@link Product} is the Key and Integer quantity amount as
	 * the Value
	 *
	 * @returning the map.
	 */
	Map<Product, Integer> getBasketProducts();

	/**
	 * Map of calculated discount text and amounts.
	 *
	 * @return Discount Map
	 */
	Map<IDiscount, BigDecimal> getDiscounts();

	/**
	 *
	 * Set Discount Map.
	 *
	 * @param discounts
	 *            map of discounts
	 */
	void setDiscounts(Map<IDiscount, BigDecimal> discounts);

	/**
	 * Checks if basket contains products;
	 *
	 * @return true if basket products found; false otherwise.
	 */
	boolean isValid();

}