/**
 * 
 */
package com.anatwine.shopping.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * 
 * Represents a Basket item.
 * 
 * @author Pete
 *
 */
public class Product implements IProduct {

	private String name;

	private BigDecimal unitPrice;

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IProduct#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IProduct#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IProduct#getUnitPrice()
	 */
	@Override
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/* (non-Javadoc)
	 * @see com.anatwine.shopping.basket.IProduct#setUnitPrice(java.math.BigDecimal)
	 */
	@Override
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Product name
	 * @param productCatalogue
	 *            {@link ProductCatalogue}
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
