/**
 * 
 */
package com.anatwine.shopping.discount;

import java.math.BigDecimal;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * 
 * Code that will add a discount to 'Destination' Product based on the minimum
 * number of a 'Source' Products added to the basket's map. e.g. Buy two Shirts
 * get 50% reduction off a tie, source and destination constructor arguments are
 * different products, or Reduce all Trousers by 10% source and destination
 * constructor arguments are the same
 * 
 * @author Pete
 *
 */
public class GenericReductionDiscount extends Discount {

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
	public GenericReductionDiscount(ProductCatalogue sourceProduct, ProductCatalogue destinationProduct,
			int qualifyingQuantity, Double percentageOff) {
		setSourceProduct(sourceProduct);
		setDestinationProduct(destinationProduct);
		setQualifyingQuantity(isValidQualifyingQuantity(qualifyingQuantity));
		setPercentageOff(isValidPercentageOff(percentageOff));
	}

	@Override
	public void applyDiscountRule(AnatwineBasket basket) {

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

		// any savings?
		if (saving.compareTo(BigDecimal.ZERO) > 0) {
			basket.getDiscounts().put(getDestinationProduct().toString().concat(" ").concat(getPercentageOffString())
					.concat(Constants.OFF_MESSAGE), saving.negate());
		}
	}

}
