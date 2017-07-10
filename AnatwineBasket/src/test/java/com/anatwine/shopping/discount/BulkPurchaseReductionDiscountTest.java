package com.anatwine.shopping.discount;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;

/**
 * @author Pete
 *
 */
public class BulkPurchaseReductionDiscountTest {

	private static final String TIE = "Tie";
	private static final String SHIRT = "Shirt";
	private GenericReductionDiscount bulkPurchaseReductionDiscount;
	private ProductCatalogue sourceProduct;
	private ProductCatalogue destinationProduct;
	private Integer qualifyingQuantity;
	private Double percentageOff;
	private AnatwineBasket mockAnatwineBasket;
	private HashMap<String, BigDecimal> discounts;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Shirt;
		destinationProduct = ProductCatalogue.Tie;
		qualifyingQuantity = 2;
		percentageOff = 0.5D;

		bulkPurchaseReductionDiscount = spy(
				new GenericReductionDiscount(sourceProduct, destinationProduct, qualifyingQuantity, percentageOff));

		mockAnatwineBasket = mock(AnatwineBasket.class);
		discounts = new HashMap<>();
		when(mockAnatwineBasket.getDiscounts()).thenReturn(discounts);

	}

	@Test
	public void shouldReturnNoDiscountWhenTwoTiesPurchased() {
		// given
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(1));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then

		verify(mockAnatwineBasket, times(0)).getDiscounts();

	}

	@Test
	public void shouldReturnTieDiscountWhenTwoShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(2));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Tie 50.0% Off ", key);
			assertEquals(new BigDecimal("-4.750"), discounts.get(key));
		}

	}

	@Test
	public void shouldReturnTiesDiscountWhenFourShirtsPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(4));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then

		for (String key : discounts.keySet()) {
			assertEquals("Tie 50.0% Off ", key);
			assertEquals(new BigDecimal("-9.500"), discounts.get(key));
		}
	}

	@Test
	public void shouldReturnTiesDiscountWhenFiveShirtsPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(5));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then

		mockAnatwineBasket.getDiscounts();

		for (String key : discounts.keySet()) {
			assertEquals("Tie 50.0% Off ", key);
			assertEquals(new BigDecimal("-9.500"), discounts.get(key));
		}
	}

	@Test
	public void shouldReturnTiesDiscountWhenSixShirtsPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(6));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(3));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Tie 50.0% Off ", key);
			assertEquals(new BigDecimal("-14.250"), discounts.get(key));
		}
	}

	@Test
	public void shouldReturnFreeTieWithEveryShirt_FutureDiscountScenario() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(1));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		qualifyingQuantity = 1;
		percentageOff = 1.0D; // 100%

		bulkPurchaseReductionDiscount = spy(
				new GenericReductionDiscount(sourceProduct, destinationProduct, qualifyingQuantity, percentageOff));

		// when
		bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (String key : discounts.keySet()) {
			assertEquals("Tie 100.0% Off ", key);
			assertEquals(new BigDecimal("-9.50"), discounts.get(key));
		}
	}

}
