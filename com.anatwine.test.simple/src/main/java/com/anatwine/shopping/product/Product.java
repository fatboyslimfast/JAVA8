/**
 * 
 */
package com.anatwine.shopping.product;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * Represents a Basket item.
 * 
 * @author Pete
 *
 */
public class Product {

	private String name;

	private BigDecimal unitPrice;

	/**
	 * @return the Product name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the Product name.
	 * 
	 * @param name
	 *            Product name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the Product's Unit price.
	 * 
	 * @return unit price.
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Set the Product's Unit price.
	 * 
	 * @param unitPrice
	 *            unit price
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Product name
	 * @param productCatalogue
	 *            {@linkProductCatalogue}
	 */
	public Product(String name, ProductCatalogue productCatalogue) {
		this.name = name;
		this.unitPrice = productCatalogue.getUnitPrice().setScale(2, RoundingMode.CEILING);
	}

	@Override
	public int hashCode() {
		return unitPrice.intValue();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		return name.equalsIgnoreCase(((Product) o).name);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
