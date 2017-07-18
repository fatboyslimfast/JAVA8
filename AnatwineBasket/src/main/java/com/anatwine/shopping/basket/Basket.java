/**
 *
 */
package com.anatwine.shopping.basket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * @author Pete
 *
 */
public class Basket {

	// Product and Quantity
	private Map<Product, Integer> basketProducts = new HashMap<>();
	// Total Basket Cost
	private BigDecimal subTotal = BigDecimal.ZERO;

	private Map<String, BigDecimal> discounts = new LinkedHashMap<>();

	/**
	 * Set basket sub total.
	 *
	 * @param subTotal
	 *            amount
	 */
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the sub total.
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}

	/**
	 * @return the discount total.
	 */
	public BigDecimal getDiscountTotal() {

		BigDecimal sum = BigDecimal.ZERO;
		for (String key : getDiscounts().keySet()) {
			sum = sum.add(getDiscounts().get(key));

		}

		return sum;
	}

	/**
	 * The basket map, {@link Product} is the Key and Integer quantity amount as
	 * the Value
	 *
	 * @returning the map.
	 */
	public Map<Product, Integer> getBasketProducts() {
		return basketProducts;
	}

	/**
	 * Map of calculated discount text and amounts.
	 *
	 * @return Discount Map
	 */
	public Map<String, BigDecimal> getDiscounts() {
		return discounts;
	}

	/**
	 *
	 * Set Discount Map.
	 *
	 * @param discounts
	 *            map of discounts
	 */
	public void setDiscounts(Map<String, BigDecimal> discounts) {
		this.discounts = discounts;
	}

	/**
	 * Checks if basket contains products;
	 *
	 * @return true if basket products found; false otherwise.
	 */
	public boolean isValid() {
		return !getBasketProducts().isEmpty();
	}

}
