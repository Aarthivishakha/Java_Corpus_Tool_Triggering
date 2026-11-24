package com.pramora.testable.metrics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComplexityLabTest {

    private final ComplexityLab lab = new ComplexityLab();

    @Test
    public void shippingTierCoversEveryDecisionOutcome() {
        assertEquals("INVALID", lab.shippingTier(0, false, false));
        assertEquals("EXPRESS_FRAGILE", lab.shippingTier(5, true, true));
        assertEquals("EXPRESS", lab.shippingTier(5, true, false));
        assertEquals("EXPRESS", lab.shippingTier(31, false, false));
        assertEquals("CAREFUL", lab.shippingTier(5, false, true));
        assertEquals("STANDARD", lab.shippingTier(30, false, false));
    }

    @Test
    public void discountTruthTableCoversEveryCondition() {
        assertTrue(lab.eligibleForDiscount(65, false, false));
        assertTrue(lab.eligibleForDiscount(30, true, false));
        assertFalse(lab.eligibleForDiscount(30, false, false));
        assertFalse(lab.eligibleForDiscount(70, true, true));
        assertFalse(lab.eligibleForDiscount(64, false, true));
    }

    @Test
    public void loyaltyPointsCoversMemberFirstOrderAndCap() {
        assertEquals(20, lab.loyaltyPoints(100, true, false));
        assertEquals(15, lab.loyaltyPoints(100, false, true));
        assertEquals(10, lab.loyaltyPoints(100, false, false));
        assertEquals(500, lab.loyaltyPoints(100000, true, false));
    }

    @Test
    public void decisionScoreCoversFullTruthTable() {
        assertEquals(1, lab.decisionScore(false, false, false));
        assertEquals(0, lab.decisionScore(false, false, true));
        assertEquals(2, lab.decisionScore(false, true, false));
        assertEquals(2, lab.decisionScore(false, true, true));
        assertEquals(2, lab.decisionScore(true, false, false));
        assertEquals(5, lab.decisionScore(true, false, true));
        assertEquals(3, lab.decisionScore(true, true, false));
        assertEquals(3, lab.decisionScore(true, true, true));
    }
}
