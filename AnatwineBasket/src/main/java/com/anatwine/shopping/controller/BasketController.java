/**
 *
 */
package com.anatwine.shopping.controller;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;
import com.anatwine.shopping.discount.Discount;
import com.anatwine.shopping.discount.DiscountFactory;
import com.anatwine.shopping.view.BasketView;

/**
 *
 *
 * @author Pete
 *
 */
public class BasketController {

	private Basket basket;
	private BasketView view;

	/**
	 * @param basket
	 * @param view
	 */
	public BasketController(Basket basket, BasketView view) {
		this.basket = basket;
		this.view = view;
	}

	/**
	 * Get the user entry and add to basket and prints the receipt.
	 */
	public void processUserEntry() {
		String[] enteredProducts = getInput();
		processProducts(enteredProducts);
		view.printReceipt(basket);
	}

	/**
	 * Return user input as String array
	 *
	 * @return String array
	 */
	private static String[] getInput() {
		System.out.print("AnatwineBasket ");
		Scanner stdin = getScanner();
		String text = stdin.nextLine();
		stdin.close();

		if (text == null || text.trim().equals("")) {
			System.err.println(Constants.NO_ITEMS_ENTERED_MSG);
			throw new IllegalArgumentException(Constants.NO_ITEMS_ENTERED_MSG);
		}

		return text.split(" ");
	}

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
	 * Empty the basket map.
	 */
	public void emptyBasket() {
		basket.getBasketProducts().clear();
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

		if (basket.getBasketProducts().containsKey(productAdd)) {
			basket.getBasketProducts().compute(productAdd, (p, q) -> Integer.valueOf(q + 1));
		} else {
			basket.getBasketProducts().put(productAdd, 1);
		}
	}

	/**
	 * Compute and output to the console the sub-total, total of any discounts
	 * to be applied and a final total.
	 */
	protected void computeTotals() {
		if (basket.isValid()) {
			calculateSubTotal();
			calculateDiscounts();
		}
	}

	/**
	 * Calculate and output to the console the sub total using the
	 * {@link Product} unit price and the number stored in the basket's map.
	 *
	 * @return sub total amount of all products in the basket.
	 */
	private void calculateSubTotal() {

		if (basket.isValid()) {

			BigDecimal amount = BigDecimal.ZERO;

			for (Product key : basket.getBasketProducts().keySet()) {
				amount = amount.add(getProductTotal(key));
			}

			basket.setSubTotal(amount);

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
		return product.getUnitPrice().multiply(new BigDecimal(basket.getBasketProducts().get(product)));
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
			discount.applyDiscountRule(basket);
		}

	}

	/**
	 * @return Scanner
	 */
	protected static Scanner getScanner() {
		return new Scanner(System.in);
	}

}
