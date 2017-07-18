/**
 *
 */
package com.anatwine.shopping.basket;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.catalogue.ProductCatalogue;
import com.anatwine.shopping.discount.Discount;
import com.anatwine.shopping.discount.DiscountFactory;

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
	 * Given an array of String product names, add these to the basket.
	 *
	 * @param products
	 *            Product Names
	 */
	public void processProducts(String[] products) {

		emptyBasket();

		for (String product : products) {
			try {
				addProductToBasket(product);
			} catch (IllegalArgumentException ex) {
				MessageFormat mf = new MessageFormat(Constants.ERROR_ADDING_TO_BASKET_MSG);
				System.err.println(
						mf.format(new Object[] { product, java.util.Arrays.asList(ProductCatalogue.values()) }));
				throw ex;
			}
		}

		computeTotals();

	}

	/**
	 * Compute and output to the console the sub-total, total of any discounts
	 * to be applied and a final total.
	 */
	protected void computeTotals() {
		if (isValid()) {
			calculateSubTotal();
			calculateDiscounts();
		}
	}

	/**
	 *
	 * Instantiate and apply {@link Discount} rules.
	 *
	 *
	 */
	private void calculateDiscounts() {
		applyDiscountStrategy(DiscountFactory.getCurrentDiscounts());
	}

	/**
	 * Calls the apply discount rule of passed {@link Discount}
	 *
	 * @param discounts
	 *            discount strategy
	 */
	private void applyDiscountStrategy(List<Discount> discounts) {
		for (Discount discount : discounts) {
			discount.applyDiscountRule(this);
		}

	}

	/**
	 *
	 * Creates a {@link Product} object using the {@link ProductCatalogue} as a
	 * lookup and, if valid, adds it to the basket's map.
	 *
	 * @param product
	 *            Product Name
	 */
	private void addProductToBasket(String product) {

		Product productAdd = new Product(product, ProductCatalogue.valueOf(product));

		if (getBasketProducts().containsKey(productAdd)) {
			getBasketProducts().compute(productAdd, (p, q) -> Integer.valueOf(q + 1));
		} else {
			getBasketProducts().put(productAdd, 1);
		}
	}

	/**
	 * Calculate and output to the console the sub total using the
	 * {@link Product} unit price and the number stored in the basket's map.
	 *
	 * @return sub total amount of all products in the basket.
	 */
	private void calculateSubTotal() {

		if (isValid()) {

			BigDecimal amount = BigDecimal.ZERO;

			for (Product key : getBasketProducts().keySet()) {
				amount = amount.add(getProductTotal(key));
			}

			setSubTotal(amount);

		}

	}

	/**
	 *
	 * Return the total cost of the product, multiplying the unit price by the
	 * quantity.
	 *
	 * @param product
	 *            a Product
	 * @return a total amount
	 */
	public BigDecimal getProductTotal(Product product) {
		return product.getUnitPrice().multiply(new BigDecimal(getBasketProducts().get(product)));
	}

	/**
	 * Empty the basket map.
	 */
	public void emptyBasket() {
		getBasketProducts().clear();
	}

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
