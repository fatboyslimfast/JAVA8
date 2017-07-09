/**
 * 
 */
package com.anatwine.shopping.catalogue;

import java.math.BigDecimal;

/**
 * Models the Products and associated Unit Price.
 * 
 * @author Pete
 *
 */
public enum ProductCatalogue {

	Jacket(new BigDecimal(49.90)), Trousers(new BigDecimal(35.50)), Shirt(new BigDecimal(12.50)), Tie(
			new BigDecimal(9.50));

	private BigDecimal unitPrice;

	/**
	 * Constructor.
	 * 
	 * @param unitPrice
	 *            unit price
	 */
	ProductCatalogue(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Unit Price of ProductCatalogue.
	 * 
	 * @return unit price.
	 */
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

}
