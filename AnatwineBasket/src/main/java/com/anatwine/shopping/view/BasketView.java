/**
 * 
 */
package com.anatwine.shopping.view;

import com.anatwine.shopping.Constants;
import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.Basket;

/**
 * @author Pete
 *
 */
public class BasketView {
	/**
	 * Print Receipt. Sub-total, any Discounts and Grand Total.
	 *
	 * @return String receipt
	 */
	public String printReceipt(Basket basket) {

		StringBuffer receipt = new StringBuffer(Constants.SUB_TOTAL_MSG)
				.append(Utils.formatAmount(basket.getSubTotal()));
		receipt.append("\n");
		if (basket.getDiscounts().size() > 0) {
			for (String key : basket.getDiscounts().keySet()) {
				receipt.append(key + ": " + Utils.formatAmount(basket.getDiscounts().get(key)));
				receipt.append("\n");
			}
		} else {
			receipt.append(Constants.NO_OFFERS_AVAILABLE_MSG);
			receipt.append("\n");
		}

		receipt.append(Constants.TOTAL_MSG)
				.append(Utils.formatAmount(basket.getSubTotal().add(basket.getDiscountTotal())));
		receipt.append("\n");
		receipt.append("===================================================================================");

		System.out.println(receipt);

		return receipt.toString();
	}
}
