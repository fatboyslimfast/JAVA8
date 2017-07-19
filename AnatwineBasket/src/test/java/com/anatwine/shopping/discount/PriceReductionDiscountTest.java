/**
 * 
 */
package com.anatwine.shopping.discount;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.Utils;
import com.anatwine.shopping.basket.Basket;
import com.anatwine.shopping.basket.Product;
import com.anatwine.shopping.catalogue.ProductCatalogue;

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
	private Basket mockAnatwineBasket;
	private HashMap<IDiscount, BigDecimal> discounts;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Trousers;
		destinationProduct = ProductCatalogue.Trousers;
		qualifyingQuantity = 1;
		percentageOff = 0.1D;

		priceReductionDiscount = spy(
				new GenericReductionDiscount(sourceProduct, destinationProduct, qualifyingQuantity, percentageOff));

		mockAnatwineBasket = mock(Basket.class);
		discounts = new HashMap<>();

		when(mockAnatwineBasket.getDiscounts()).thenReturn(discounts);

	}

	@Test
	public void shouldReturnNoDiscountWhenTwoShirtsPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key);
			assertEquals(Utils.formatAmount(new BigDecimal("-7.10")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void shouldReturnTrouserDiscountWhenOneTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(1));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-3.55")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void shouldReturnTrouserDiscountWhenTwoTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(2));
		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-7.10")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void shouldReturnTrouserDiscountWhenThreeTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(3));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-10.65")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void shouldReturnTrouserDiscountWhenOneHundredTrousersPurchased() {
		// given

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(100));

		basketProducts.put(new Product(SHIRTS, ProductCatalogue.Shirt), new Integer(1));
		basketProducts.put(new Product(TIE, ProductCatalogue.Tie), new Integer(2));
		basketProducts.put(new Product(JACKET, ProductCatalogue.Jacket), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 10.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-355.00")), Utils.formatAmount(discounts.get(key)));
		}
	}

	@Test
	public void shouldBuyOneGetOneFree_FutureDiscountScenario() {

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(2));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		priceReductionDiscount = spy(new GenericReductionDiscount(sourceProduct, destinationProduct, 2, 1D));

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 100.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-35.50")), Utils.formatAmount(discounts.get(key)));
		}

	}

	@Test
	public void shouldBuyTwoGetTwoFree_FutureDiscountScenario() {

		Map<Product, Integer> basketProducts = new HashMap<>();
		basketProducts.put(new Product(TROUSERS, ProductCatalogue.Trousers), new Integer(4));
		doReturn(basketProducts).when(mockAnatwineBasket).getBasketProducts();

		priceReductionDiscount = spy(new GenericReductionDiscount(sourceProduct, destinationProduct, 2, 1D));

		// when
		priceReductionDiscount.applyDiscountRule(mockAnatwineBasket);

		// then
		for (IDiscount key : discounts.keySet()) {
			assertEquals("Trousers 100.0% Off ", key.toString());
			assertEquals(Utils.formatAmount(new BigDecimal("-71.00")), Utils.formatAmount(discounts.get(key)));
		}

	}

}
