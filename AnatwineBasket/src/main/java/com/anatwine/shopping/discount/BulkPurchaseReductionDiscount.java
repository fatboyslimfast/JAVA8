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
 * Code that will add a discount to 'Destination' Product based on the minimum
 * number of a 'Source' Products added to the basket's map. e.g. Buy two Shirts
 * get 50% reduction off a tie.
 * 
 * @author Pete
 *
 */
public class BulkPurchaseReductionDiscount extends Discount {

	/**
	 * 
	 * Constructor
	 * 
	 * @param sourceProduct
	 *            Source {@link Product}
	 * @param destinationProduct
	 *            Destination {@link Product}
	 * @param qualifyingQuantity
	 *            minimum threshold quantity
	 * @param percentageOff
	 *            percentage value represented by a number between 0 and 1. i.e
	 *            0.5 = 50%
	 */
	public BulkPurchaseReductionDiscount(ProductCatalogue sourceProduct, ProductCatalogue destinationProduct,
			Integer qualifyingQuantity, Double percentageOff) {
		setSourceProduct(sourceProduct);
		setDestinationProduct(destinationProduct);
		setQualifyingQuantity(qualifyingQuantity);
		setPercentageOff(percentageOff);
	}

	@Override
	public BigDecimal applyDiscountRule(AnatwineBasket basket) {

		BigDecimal saving = BigDecimal.ZERO;

		Integer sourceProductCount = basket.getBasketProducts()
				.get(new Product(getSourceProduct().toString(), getSourceProduct()));

		if (sourceProductCount != null && sourceProductCount >= getQualifyingQuantity()) {
			int destinationProductCount = sourceProductCount / getQualifyingQuantity();
			for (Product product : basket.getBasketProducts().keySet()) {
				if (product.getName().equals(getDestinationProduct().toString())) {

					if (basket.getBasketProducts().get(product) < destinationProductCount) {
						saving = product.getUnitPrice().multiply(new BigDecimal(getPercentageOff())
								.multiply(new BigDecimal(basket.getBasketProducts().get(product))));
					} else {
						saving = product.getUnitPrice().multiply(
								new BigDecimal(getPercentageOff()).multiply(new BigDecimal(destinationProductCount)));
					}

					break;

				}
			}

		}

		if (saving.compareTo(BigDecimal.ZERO) > 0) {
			System.out.println(getDestinationProduct().toString().concat(" ").concat(getPercentageOffString())
					.concat(Constants.OFF_MESSAGE).concat(Utils.formatAmount(saving.negate())));
		}

		return saving;
	}

}
