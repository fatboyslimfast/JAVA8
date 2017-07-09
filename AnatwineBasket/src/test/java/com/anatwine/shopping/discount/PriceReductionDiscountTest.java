/**
 * 
 */
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
public class PriceReductionDiscountTest {

	private static final String TROUSERS = "Trousers";
	private static final String JACKET = "Jacket";
	private static final String TIE = "Tie";
	private static final String SHIRTS = "Shirts";
	private GenericReductionDiscount priceReductionDiscount;
	private ProductCatalogue sourceProduct;
	private ProductCatalogue destinationProduct;
	private Integer qualifyingQuantity;
	private Double percentageOff;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Trousers;
		destinationProduct = ProductCatalogue.Trousers;
		qualifyingQuantity = new Integer(1);
		percentageOff = 0.1D;

		priceReductionDiscount = spy(
				new GenericReductionDiscount(sourceProduct, destinationProduct, qualifyingQuantity, percentageOff));

	}

	@Test
	public void testReturnNoDiscountWhenTwoShirtsPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("0.00")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTrouserDiscountWhenOneTrousersPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(1));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("3.55")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTrouserDiscountWhenTwoTrousersPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(2));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("7.10")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTrouserDiscountWhenThreeTrousersPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(3));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("10.65")), Utils.formatAmount(saving));
	}

	@Test
	public void testReturnTrouserDiscountWhenOneHundredTrousersPurchased() {
		// given

		AnatwineBasket mockAnatwineBasket = mock(AnatwineBasket.class);
		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(100));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		BigDecimal saving = priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		assertEquals(Utils.formatAmount(new BigDecimal("355.00")), Utils.formatAmount(saving));
	}

}
