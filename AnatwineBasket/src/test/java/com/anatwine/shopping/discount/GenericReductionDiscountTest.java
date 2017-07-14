package com.anatwine.shopping.discount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.anatwine.shopping.catalogue.ProductCatalogue;

public class GenericReductionDiscountTest {

	private GenericReductionDiscount genericReductionDiscount;
	private ProductCatalogue sourceProduct;
	private ProductCatalogue destinationProduct;
	private Integer qualifyingQuantity;
	private Double percentageOff;

	@Before
	public void setUp() throws Exception {

		// class we are testing
		sourceProduct = ProductCatalogue.Shirt;
		destinationProduct = ProductCatalogue.Tie;
		qualifyingQuantity = 2;
		percentageOff = 0.5D;

	}

	@Test
	public void shouldThrowExceptionIfQualifyingQuantityZero() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct, 0,
					percentageOff);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Qualifying Quantity value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionIfQualifyingQuantityLessThanZero() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct, -1,
					percentageOff);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Qualifying Quantity value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldNotThrowExceptionIfQualifyingQuantityEqualsOne() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct, 1,
					percentageOff);
		} catch (Exception ex) {
			fail("Test should have passed");

		}
	}

	@Test
	public void shouldNotThrowExceptionIfQualifyingQuantityGreaterThanOne() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct, 2,
					percentageOff);
		} catch (Exception ex) {
			fail("Test should have passed");

		}
	}

	@Test
	public void shouldThrowExceptionIfPercentageOffIsNull() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, null);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Percentage Off value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionIfPercentageOffIsZero() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, 0D);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Percentage Off value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionIfPercentageOffIsLessThanZero() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, -0.01D);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Percentage Off value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldThrowExceptionIfPercentageOffIsGreaterThanOne() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, 1.0001D);
			fail("Test should have failed");
		} catch (IllegalArgumentException ex) {
			assertEquals("Invalid Percentage Off value specified.", ex.getMessage());
		}
	}

	@Test
	public void shouldNotThrowExceptionIfPercentageOffIsValid() {
		try {
			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, 0.01D);

			genericReductionDiscount = new GenericReductionDiscount(sourceProduct, destinationProduct,
					qualifyingQuantity, 1D);

		} catch (IllegalArgumentException ex) {
			fail("Test should have passed");
		}
	}

}
