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
public class Basket implements IBasket {

	// Product and Quantity
	private Map<Product, Integer> basketProducts = new HashMap<>();
	// Total Basket Cost
	private BigDecimal subTotal = BigDecimal.ZERO;

	private Map<String, BigDecimal> discounts = new LinkedHashMap<>();

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#setSubTotal(java.math.BigDecimal)
	 */
	@Override
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#getSubTotal()
	 */
	@Override
	public BigDecimal getSubTotal() {
		return subTotal;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#getDiscountTotal()
	 */
	@Override
	public BigDecimal getDiscountTotal() {

		BigDecimal sum = BigDecimal.ZERO;
		for (String key : getDiscounts().keySet()) {
			sum = sum.add(getDiscounts().get(key));

		}

		return sum;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#getBasketProducts()
	 */
	@Override
	public Map<Product, Integer> getBasketProducts() {
		return basketProducts;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#getDiscounts()
	 */
	@Override
	public Map<String, BigDecimal> getDiscounts() {
		return discounts;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#setDiscounts(java.util.Map)
	 */
	@Override
	public void setDiscounts(Map<String, BigDecimal> discounts) {
		this.discounts = discounts;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IBasket#isValid()
	 */
	@Override
	public boolean isValid() {
		return !getBasketProducts().isEmpty();
	}

}
