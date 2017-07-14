package com.anatwine.shopping.discount;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BulkPurchaseReductionDiscountTest.class, GenericReductionDiscountTest.class,
		PriceReductionDiscountTest.class })
public class AllDiscountTests {

}
