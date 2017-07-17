/**
 *
 */
package com.anatwine.shopping.discount;

import java.util.ArrayList;
import java.util.List;

import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * @author pche0001
 *
 */
public final class DiscountFactory {

	static List<Discount> currentDiscounts = new ArrayList<>();

	/**
	 *
	 * @return List of current Discounts
	 */
	public static List<Discount> getCurrentDiscounts() {
		currentDiscounts
				.add(new GenericReductionDiscount(ProductCatalogue.Trousers, ProductCatalogue.Trousers, 1, 0.1D));

		currentDiscounts.add(new GenericReductionDiscount(ProductCatalogue.Shirt, ProductCatalogue.Tie, 2, 0.5D));

		return currentDiscounts;
	}

}
