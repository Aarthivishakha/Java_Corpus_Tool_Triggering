package com.pramora.testable.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Baseline run: one small test, so the next commit's coverage change can be measured. */
public class SmokeTest {

    @Test
    public void goldTierDiscount() {
        assertEquals(7, LoyaltyTier.GOLD.getDiscountPercent());
    }
}
