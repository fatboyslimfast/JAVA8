package com.anatwine.shopping.discount;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.AnatwineBasket;
import com.anatwine.shopping.product.Product;
import com.anatwine.shopping.product.ProductCatalogue;

/**
 * @author Pete
 *
 */
public class BulkPurchaseReductionDiscountTest {

	private static final String TIE = "Tie";
	private static final String SHIRT = "Shirt";
	private BulkPurchaseReductionDiscount bulkPurchaseReductionDiscount;
	private ProductCatalogue sourceProduct;
	private ProductCatalogue destinationProduct;
	private Integer qualifyingQuantity;
	private Double percentageOff;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Shirt;
		destinationProduct = ProductCatalogue.Tie;
		qualifyingQuantity = new Integer(2);
		percentageOff = 0.5D;

		bulkPurchaseReductionDiscount = spy(new BulkPurchaseReductionDiscount(sourceProduct, destinationProduct,
				qualifyingQuantity, percentageOff));

	}

	@Test
	public void testReturnNoDiscountWhenTwoShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(1));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("0.00")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTieDiscountWhenTwoShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(2));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("4.750")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTiesDiscountWhenFourShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(4));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("9.50")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTiesDiscountWhenFiveShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(5));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("9.50")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTiesDiscountWhenSixShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRT, sourceProduct), new Integer(6));
		basketProducts.put(new Product(TIE, destinationProduct), new Integer(3));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = bulkPurchaseReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("14.25")), Utils.formatAmount(saving));
	}

}
