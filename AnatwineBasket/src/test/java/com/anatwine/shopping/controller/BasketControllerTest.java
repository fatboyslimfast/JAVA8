package com.anatwine.shopping.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.view.BasketView;

public class BasketControllerTest {

	private static final String JACKET = "Jacket";
	private static final String SHIRT = "Shirt";
	private static final String TIE = "Tie";
	private static final String COAT = "Coat";
	private static final String TROUSERS = "Trousers";
	private Basket basket;
	private BasketView basketView;
	private BasketController basketController;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		basket = new Basket();
		basketView = new BasketView();
		basketController = spy(new BasketController(basket, basketView));

	}

	@Test
	public void shouldAddNoProductToBasket() {
		// given

		String[] products = new String[] {};
		// when
		basketController.processProducts(products);

		// then
		assertFalse(basket.isValid());
		assertEquals(0, basket.getBasketProducts().size());
		assertEquals(BigDecimal.ZERO, basket.getDiscountTotal());
		assertEquals(BigDecimal.ZERO, basket.getSubTotal());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenAddingUnknownProductToBasket() {
		// given
		String[] products = new String[] { TROUSERS, COAT };
		// when
		basketController.processProducts(products);

	}

	@Test
	public void shouldAddSingleProductToBasket() {
		// given

		String[] products = new String[] { TROUSERS };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(1, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TROUSERS)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("-3.55")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("35.50")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldAddSingleProductsToBasket() {
		// given

		String[] products = new String[] { TROUSERS, TIE, SHIRT, JACKET };
		// when
		basketController.processProducts(products);

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TROUSERS)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(TIE)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(JACKET)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			}
		}

		// then
		assertTrue(basket.isValid());
		assertEquals(4, basket.getBasketProducts().size());

	}

	@Test
	public void shouldAddMultipleProductsToBasket() {
		// given

		String[] products = new String[] { TROUSERS, TIE, SHIRT, JACKET, TROUSERS, TIE, };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(4, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TROUSERS)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(TIE)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(JACKET)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			}
		}

	}

	@Test
	public void shouldCalculateZeroDiscountWhenMultipleNonDiscountProductsAddedToBasket() {
		// given

		String[] products = new String[] { TIE, SHIRT, JACKET, TIE, };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(3, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TIE)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(JACKET)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("0.00")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("81.40")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldCalculateDiscountsWhen4ShirtsAnd1TieAddedToBasket() {
		// given

		String[] products = new String[] { TIE, SHIRT, SHIRT, SHIRT, SHIRT };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(2, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TIE)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(4), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("-4.75")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("59.50")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldCalculateDiscountsWhen4ShirtsAnd2TiesAddedToBasket() {
		// given

		String[] products = new String[] { TIE, TIE, SHIRT, SHIRT, SHIRT, SHIRT };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(2, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TIE)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(4), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("-9.50")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("69.00")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldCalculateDiscountsWhen5ShirtsAnd2TiesAddedToBasket() {
		// given

		String[] products = new String[] { TIE, TIE, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(2, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TIE)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(5), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("-9.50")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("81.50")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldCalculateDiscountsWhen6ShirtsAnd2TiesAndTrousersAddedToBasket() {
		// given

		String[] products = new String[] { TIE, TIE, SHIRT, SHIRT, SHIRT, SHIRT, SHIRT, TROUSERS };
		// when
		basketController.processProducts(products);

		// then
		assertTrue(basket.isValid());
		assertEquals(3, basket.getBasketProducts().size());

		for (Product key : basket.getBasketProducts().keySet()) {
			if (key.getName().equals(TROUSERS)) {
				assertEquals(new Integer(1), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(TIE)) {
				assertEquals(new Integer(2), basket.getBasketProducts().get(key));
			} else if (key.getName().equals(SHIRT)) {
				assertEquals(new Integer(5), basket.getBasketProducts().get(key));
			}
		}

		assertEquals(Utils.formatAmount(new BigDecimal("-13.05")), Utils.formatAmount(basket.getDiscountTotal()));
		assertEquals(Utils.formatAmount(new BigDecimal("117.00")), Utils.formatAmount(basket.getSubTotal()));

	}

	@Test
	public void shouldProcessValidUserEntry() {
		String input = "Tie Tie Tie";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// when
		basketController.processUserEntry();

		// then
		verify(basketController, times(1)).processProducts(input.split(" "));
	}

	@Test
	public void shouldThrowExceptionProcessingInValidUserEntry() {
		try {
			String input = " ";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			// when
			basketController.processUserEntry();
			fail("Test should have thrown Exception");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Entry: No Items Entered", ex.getMessage());
		}

	}

}
