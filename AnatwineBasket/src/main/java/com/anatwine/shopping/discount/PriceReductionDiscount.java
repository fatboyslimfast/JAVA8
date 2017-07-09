/**
 * 
 */
package com.anatwine.shopping.discount;

import java.math.BigDecimal;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.product.Product;
import com.anatwine.shopping.product.ProductCatalogue;

/**
 * 
 * Code that will add a discount to 'Source' Product by a given percentage
 * amount. e.g. Reduce all Trousers by 10%
 * 
 * @author Pete
 *
 */
public class PriceReductionDiscount extends Discount {

	/**
	 * Constructor
	 * 
	 * @param sourceProduct
	 *            Source {@link Product}
	 * @param percentageOff
	 *            percentage value represented by a number between 0 and 1. i.e
	 *            0.1 = 10%
	 */
	public PriceReductionDiscount(ProductCatalogue sourceProduct, Double percentageOff) {
		setSourceProduct(sourceProduct);
		setPercentageOff(percentageOff);
	}

	@Override
	public BigDecimal applyDiscountRule(AnatwineBasket basket) {
		BigDecimal saving = BigDecimal.ZERO;
		for (Product product : basket.getBasketProducts().keySet()) {
			if (product.getName().equals(getSourceProduct().toString())) {
				saving = saving.add(getProductTotal(product, basket).multiply(new BigDecimal(getPercentageOff())));
				System.out.println(getSourceProduct().toString().concat(" ").concat(getPercentageOffString())
						.concat(Constants.OFF_MESSAGE).concat(Utils.formatAmount(saving.negate())));
			}
		}

		return saving;
	}

}
