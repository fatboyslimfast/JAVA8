/**
 * 
 */
package com.anatwine.shopping.basket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.Utils;
import com.anatwine.shopping.discount.Discount;
import com.anatwine.shopping.discount.GenericReductionDiscount;
import com.anatwine.shopping.product.Product;
import com.anatwine.shopping.product.ProductCatalogue;

/**
 * 
 * 
 * @author Pete
 *
 */
public class AnatwineBasket {

	// Product and Quantity
	private Map<Product, Integer> basketProducts = new HashMap<>();
	// Total Basket Cost
	private BigDecimal subTotal;
	// Total Discounted Amount
	private BigDecimal discountTotal;

	/**
	 * @param products
	 *            Array of Product Names
	 */
	public static void main(String[] products) {
		AnatwineBasket basket = new AnatwineBasket();
		basket.processProducts(products);
	}

	/**
	 * Given an array of String product names, add these to the basket.
	 * 
	 * @param products
	 *            Product Names
	 */
	protected void processProducts(String[] products) {

		emptyBasket();

		for (String product : products) {
			try {
				addProductToBasket(product);
			} catch (IllegalArgumentException ex) {
				System.err.println(Constants.ERROR_ADDING_TO_BASKET_MSG + " " + ex.getMessage());
				throw ex;
			}
		}

		computeTotals();
	}

	/**
	 * Compute and output to the console the sub-total, total of any discounts
	 * to be applied and a final total.
	 */
	public void computeTotals() {
		if (getBasketProducts().size() > 0) {
			subTotal = calculateSubTotal();
			discountTotal = calculateDiscounts();
			System.out.println(Constants.TOTAL_MSG + Utils.formatAmount(subTotal.subtract(discountTotal)));
			System.out.println("==========================================");
		}

	}

	/**
	 * 
	 * Instantiate and apply {@link Discount} rules. If none are applied '0' is
	 * returned.
	 * 
	 * @return Total Discount amount
	 */
	private BigDecimal calculateDiscounts() {

		/*
		 * Discount trousersDiscount = new
		 * PriceReductionDiscount(ProductCatalogue.Trousers, 0.1D);
		 * 
		 * BigDecimal saving = trousersDiscount.applyDiscountRule(this);
		 * 
		 * Discount bulkShirtPurchaseDiscount = new
		 * BulkPurchaseReductionDiscount(ProductCatalogue.Shirt,
		 * ProductCatalogue.Tie, 2, 0.5D);
		 * 
		 * saving =
		 * saving.add(bulkShirtPurchaseDiscount.applyDiscountRule(this));
		 */

		Discount trousersDiscount = new GenericReductionDiscount(ProductCatalogue.Trousers, ProductCatalogue.Trousers,
				1, 0.1D);

		BigDecimal saving = trousersDiscount.applyDiscountRule(this);

		Discount bulkShirtPurchaseDiscount = new GenericReductionDiscount(ProductCatalogue.Shirt, ProductCatalogue.Tie,
				2, 0.5D);

		saving = saving.add(bulkShirtPurchaseDiscount.applyDiscountRule(this));

		if (saving.compareTo(BigDecimal.ZERO) != 0) {
			return saving;
		}

		System.out.println(Constants.NO_OFFERS_AVAILABLE_MSG);
		return BigDecimal.ZERO;

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
	private BigDecimal calculateSubTotal() {

		if (getBasketProducts().size() > 0) {

			BigDecimal amount = BigDecimal.ZERO;

			for (Product key : getBasketProducts().keySet()) {
				amount = amount.add(getProductTotal(key));
			}

			System.out.println(Constants.SUB_TOTAL_MSG + Utils.formatAmount(amount));

			return amount;

		} else {
			return null;
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
	private BigDecimal getProductTotal(Product product) {
		return product.getUnitPrice().multiply(new BigDecimal(getBasketProducts().get(product)));
	}

	/**
	 * Empty the basket map.
	 */
	public void emptyBasket() {
		getBasketProducts().clear();
	}

	/**
	 * @return the sub total.
	 */
	protected BigDecimal getSubTotal() {
		return subTotal;
	}

	/**
	 * @return the discount total.
	 */
	public BigDecimal getDiscountTotal() {
		return discountTotal;
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

}
