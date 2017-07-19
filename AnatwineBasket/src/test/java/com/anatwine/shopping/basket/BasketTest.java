package com.anatwine.shopping.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.discount.Discount;
import com.anatwine.shopping.discount.IDiscount;

/**
 * @author Pete
 *
 */
public class BasketTest {

	private Basket basket;
	private Discount discount1;
	private Discount discount2;
	private Discount discount3;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		basket = spy(new Basket());

		discount1 = mock(Discount.class);
		when(discount1.toString()).thenReturn("Offer 1");
		discount2 = mock(Discount.class);
		when(discount2.toString()).thenReturn("Offer 2");
		discount3 = mock(Discount.class);
		when(discount3.toString()).thenReturn("Offer 3");

	}

	@Test
	public void shouldOnlyStoreUniqueDiscounts() {

		// given
		Map<IDiscount, BigDecimal> discounts = new LinkedHashMap<>();
		discounts.put(discount1, new BigDecimal("-1.00"));
		discounts.put(discount2, new BigDecimal("-2.00"));
		doReturn(discounts).when(basket).getDiscounts();

		// when
		basket.getDiscounts().put(discount3, new BigDecimal("-3.00"));

		// then

		assertEquals(3, basket.getDiscounts().size());
		for (IDiscount key : discounts.keySet()) {
			if (key.toString().equals("Offer 1")) {
				assertEquals(new BigDecimal("-1.00"), discounts.get(key));
			} else if (key.toString().equals("Offer 2")) {
				assertEquals(new BigDecimal("-2.00"), discounts.get(key));
			} else if (key.toString().equals("Offer 3")) {
				assertEquals(new BigDecimal("-3.00"), discounts.get(key));
			} else {
				fail("Unknown discount entry");
			}
		}

	}

	@Test
	public void shouldOverwriteWithLatestDiscounts() {

		// given
		Map<IDiscount, BigDecimal> discounts = new LinkedHashMap<>();
		discounts.put(discount1, new BigDecimal("-1.00"));
		discounts.put(discount2, new BigDecimal("-2.00"));
		doReturn(discounts).when(basket).getDiscounts();

		// when
		basket.getDiscounts().put(discount1, new BigDecimal("-3.00"));

		// then

		assertEquals(2, basket.getDiscounts().size());
		for (IDiscount key : discounts.keySet()) {
			if (key.toString().equals("Offer 1")) {
				assertEquals(new BigDecimal("-3.00"), discounts.get(key));
			} else if (key.toString().equals("Offer 2")) {
				assertEquals(new BigDecimal("-2.00"), discounts.get(key));
			} else {
				fail("Unknown discount entry");
			}
		}

	}

}
