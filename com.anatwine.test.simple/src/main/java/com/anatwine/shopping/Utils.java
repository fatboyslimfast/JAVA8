package com.anatwine.shopping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * 
 * Helper class for Shopping Basket functionality.
 * 
 * @author Pete
 *
 */
public final class Utils {

	private Utils() {
	} // Prevent the class from being constructed

	/**
	 * Formats the amount into UK currency format.
	 * 
	 * @param amount
	 *            the amount
	 * @return UK currency format
	 */
	public static String formatAmount(BigDecimal amount) {
		if (amount != null) {
			NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
			return nf.format(amount);
		}
		return null;
	}

}
