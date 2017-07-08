package com.anatwine.shopping.discount;

import java.math.BigDecimal;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.product.Product;
import com.anatwine.shopping.product.ProductCatalogue;

/**
 * @author Pete
 *
 */
public abstract class Discount {

	/* Source of discount */
	ProductCatalogue sourceProduct = null;
	/* Beneficiary of discount */
	ProductCatalogue destinationProduct = null;
	/* Qualifying Threshold Amount */
	Integer qualifyingQuantity = null;
	/* Percentage discount applied to Unit Price (between 0.0 & 1.0) */
	Double percentageOff = null;

	/**
	 * Logic to return and output to the console total discount amount.
	 * 
	 * @param basket
	 *            the current basket
	 * @return total discount amount
	 */
	public abstract BigDecimal applyDiscountRule(AnatwineBasket basket);

	/*
	 * Return the Product Total Cost Price
	 */
	protected static BigDecimal getProductTotal(Product product, AnatwineBasket basket) {
		return product.getUnitPrice().multiply(new BigDecimal(basket.getBasketProducts().get(product)));
	}

	/**
	 * @return the source {@link Product}
	 */
	protected ProductCatalogue getSourceProduct() {
		return sourceProduct;
	}

	/**
	 * @param sourceProduct
	 *            set the source {@link Product}
	 */
	protected void setSourceProduct(ProductCatalogue sourceProduct) {
		this.sourceProduct = sourceProduct;
	}

	/**
	 * @return the percentage reduction to be applied.
	 */
	protected Double getPercentageOff() {
		return percentageOff;
	}

	/**
	 * @param percentageOff
	 *            set the percentage reduction to be applied.
	 */
	protected void setPercentageOff(Double percentageOff) {
		this.percentageOff = percentageOff;
	}

	/**
	 * @return the percentage reduction to be applied as String representation.
	 */
	protected String getPercentageOffString() {
		return String.valueOf(getPercentageOff() * 100).concat(Constants.PERCENTAGE_SYMBOL);
	}

	/**
	 * @return the destination {@link Product}
	 */
	protected ProductCatalogue getDestinationProduct() {
		return destinationProduct;
	}

	/**
	 * @param destinationProduct
	 *            set the Destination {@link Product}
	 */
	protected void setDestinationProduct(ProductCatalogue destinationProduct) {
		this.destinationProduct = destinationProduct;
	}

	/**
	 * @return the qualifying quantity.
	 */
	protected Integer getQualifyingQuantity() {
		return qualifyingQuantity;
	}

	/**
	 * @param qualifyingQuantity
	 *            set the qualifying quantity.
	 */
	protected void setQualifyingQuantity(Integer qualifyingQuantity) {
		this.qualifyingQuantity = qualifyingQuantity;
	}

}
