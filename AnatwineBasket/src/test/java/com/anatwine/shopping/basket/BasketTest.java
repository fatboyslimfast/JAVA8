package com.anatwine.shopping.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Pete
 *
 */
public class BasketTest {

	private Basket basket;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		basket = spy(new Basket());

	}

	@Test
	public void shouldOnlyStoreUniqueDiscounts() {

		// given
		Map<String, BigDecimal> discounts = new LinkedHashMap<>();
		discounts.put("Offer 1", new BigDecimal("-1.00"));
		discounts.put("Offer 2", new BigDecimal("-2.00"));
		doReturn(discounts).when(basket).getDiscounts();

		// when
		basket.getDiscounts().put("Offer 3", new BigDecimal("-3.00"));

		// then

		assertEquals(3, basket.getDiscounts().size());
		for (String key : discounts.keySet()) {
			if (key.equals("Offer 1")) {
				assertEquals(new BigDecimal("-1.00"), discounts.get(key));
			} else if (key.equals("Offer 2")) {
				assertEquals(new BigDecimal("-2.00"), discounts.get(key));
			} else if (key.equals("Offer 3")) {
				assertEquals(new BigDecimal("-3.00"), discounts.get(key));
			} else {
				fail("Unknown discount entry");
			}
		}

	}

	@Test
	public void shouldOverwriteWithLatestDiscounts() {

		// given
		Map<String, BigDecimal> discounts = new LinkedHashMap<>();
		discounts.put("Offer 1", new BigDecimal("-1.00"));
		discounts.put("Offer 2", new BigDecimal("-2.00"));
		doReturn(discounts).when(basket).getDiscounts();

		// when
		basket.getDiscounts().put("Offer 1", new BigDecimal("-3.00"));

		// then

		assertEquals(2, basket.getDiscounts().size());
		for (String key : discounts.keySet()) {
			if (key.equals("Offer 1")) {
				assertEquals(new BigDecimal("-3.00"), discounts.get(key));
			} else if (key.equals("Offer 2")) {
				assertEquals(new BigDecimal("-2.00"), discounts.get(key));
			} else {
				fail("Unknown discount entry");
			}
		}

	}

}
