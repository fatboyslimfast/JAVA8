package com.anatwine.shopping.discount;

import java.math.BigDecimal;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * @author Pete
 *
 */
public abstract class Discount implements IDiscount {

	/* Source of discount */
	ProductCatalogue sourceProduct = null;
	/* Beneficiary of discount */
	ProductCatalogue destinationProduct = null;
	/* Qualifying Threshold Amount */
	Integer qualifyingQuantity = null;
	/* Percentage discount applied to Unit Price (between 0.0 & 1.0) */
	Double percentageOff = null;

	/*
	 * Return the Product Total Cost Price
	 */
	protected static BigDecimal getProductTotal(Product product, Basket basket) {
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

	/**
	 * Validate Percentage Off value is not null and between 0 and 1.
	 *
	 * @param percentageOff
	 *            percentage off
	 * @return percentageOff if valid
	 */
	protected Double isValidPercentageOff(Double percentageOff) {
		if (percentageOff == null || percentageOff <= 0 || percentageOff > 1) {
			System.err.println("Invalid Percentage Off value specified");
			throw new IllegalArgumentException("Invalid Percentage Off value specified.");
		}
		return percentageOff;
	}

	/**
	 * Validate Qualifying Quantity is greater than zero.
	 *
	 * @param qualifyingQuantity
	 *            Qualifying Quantity to validate
	 * @return
	 */
	protected int isValidQualifyingQuantity(int qualifyingQuantity) {
		if (qualifyingQuantity <= 0) {
			System.err.println("Invalid Qualifying Quantity value specified");
			throw new IllegalArgumentException("Invalid Qualifying Quantity value specified.");
		}

		return qualifyingQuantity;
	}

}
