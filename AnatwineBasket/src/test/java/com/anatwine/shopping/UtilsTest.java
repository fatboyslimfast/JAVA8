package com.anatwine.shopping;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testNullParameter() {
		Utils.formatAmount(null);
	}

	@Test
	public void testZeroParameter() {
		assertEquals("£0.00", Utils.formatAmount(BigDecimal.ZERO));
	}

	@Test
	public void testOneParameter() {
		assertEquals("£1.00", Utils.formatAmount(BigDecimal.ONE));
	}

	@Test
	public void testTenParameter() {
		assertEquals("£10.00", Utils.formatAmount(BigDecimal.TEN));
	}

	@Test
	public void testLargeParameter() {
		assertEquals("£12.25", Utils.formatAmount(new BigDecimal("12.25423423423412312312312")));
	}

	@Test
	public void testLarge2Parameter() {
		assertEquals("£99.26", Utils.formatAmount(new BigDecimal("99.25623423423412312312312")));
	}

	@Test
	public void testLarge3Parameter() {
		assertEquals("£99.26", Utils.formatAmount(new BigDecimal("099.25623423423412312312312")));
	}

	@Test
	public void testNegativeParameter() {
		assertEquals("-£99.99", Utils.formatAmount(new BigDecimal("-99.99")));
	}

}
