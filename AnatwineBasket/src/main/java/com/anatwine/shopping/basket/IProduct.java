package com.anatwine.shopping.basket;

import java.math.BigDecimal;

public interface IProduct {

	/**
	 * @return the Product name.
	 */
	String getName();

	/**
	 * Set the Product name.
	 * 
	 * @param name
	 *            Product name
	 */
	void setName(String name);

	/**
	 * Get the Product's Unit price.
	 * 
	 * @return unit price.
	 */
	BigDecimal getUnitPrice();

	/**
	 * Set the Product's Unit price.
	 * 
	 * @param unitPrice
	 *            unit price
	 */
	void setUnitPrice(BigDecimal unitPrice);

}