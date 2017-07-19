package com.anatwine.shopping.discount;

import com.anatwine.shopping.basket.IBasket;
import com.anatwine.shopping.catalogue.ProductCatalogue;

public interface IDiscount {

	/**
	 * Update the baskets discounts map.
	 *
	 * @param basket
	 *            the current basket
	 * @return total discount amount
	 */
	void applyDiscountRule(IBasket basket);

	ProductCatalogue getDestinationProduct();

	Double getPercentageOff();

	String getPercentageOffString();

	Integer getQualifyingQuantity();

	ProductCatalogue getSourceProduct();

	void setDestinationProduct(ProductCatalogue catalogue);

	void setPercentageOff(Double percent);

	void setQualifyingQuantity(Integer qualifyingAmount);

	void setSourceProduct(ProductCatalogue catalogue);

}