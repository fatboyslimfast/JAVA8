package com.anatwine.shopping.basket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.view.BasketView;

/**
 * @author Pete
 *
 */
public class BasketViewTest {

	private Basket basket;
	private BasketView basketView;

	@Before
	public void setUp() throws Exception {

		basket = mock(Basket.class);
		// class we are testing
		basketView = spy(new BasketView());

	}

	@Test
	public void shouldPrintBasketReceiptWithDiscounts() {

		// given
		when(basket.getSubTotal()).thenReturn(new BigDecimal("10.00"));
		Map<String, BigDecimal> discounts = new LinkedHashMap<>();
		discounts.put("Offer 1", new BigDecimal("-1.00"));
		discounts.put("Offer 2", new BigDecimal("-2.00"));
		doReturn(discounts).when(basket).getDiscounts();
		when(basket.getDiscountTotal()).thenReturn(new BigDecimal("-3.00"));

		// when
		String receipt = basketView.printReceipt(basket);

		// then

		StringBuffer expectedReceipt = new StringBuffer("Sub Total : £10.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("Offer 1: -£1.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("Offer 2: -£2.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("Total : £7.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("===================================================================================");

		assertEquals(expectedReceipt.toString(), receipt);

	}

	@Test
	public void shouldPrintBasketReceiptWithoutDiscounts() {

		// given
		when(basket.getSubTotal()).thenReturn(new BigDecimal("10.00"));
		when(basket.getDiscountTotal()).thenReturn(BigDecimal.ZERO);

		Map<String, BigDecimal> discounts = new LinkedHashMap<>();
		doReturn(discounts).when(basket).getDiscounts();

		// when
		String receipt = basketView.printReceipt(basket);

		StringBuffer expectedReceipt = new StringBuffer("Sub Total : £10.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("(No offers available)");
		expectedReceipt.append("\n");
		expectedReceipt.append("Total : £10.00");
		expectedReceipt.append("\n");
		expectedReceipt.append("===================================================================================");

		assertEquals(expectedReceipt.toString(), receipt);

	}

}
