package com.pramora.testable.metrics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LintLabTest {

    private final LintLab lab = new LintLab();

    @Test
    public void computeTotalCapsAtMaxItems() {
        assertEquals(7, lab.Compute_total(3, 4));
        assertEquals(10, lab.Compute_total(8, 9));
    }

    @Test
    public void describeMapsCodesToWords() {
        assertEquals("one", lab.describe(1));
        assertEquals("eight", lab.describe(8));
        assertEquals("many", lab.describe(99));
    }

    @Test
    public void usedDespiteNameReturnsInput() {
        assertEquals(5, lab.usedDespiteName(5));
    }

    @Test
    public void logDoesNotThrow() {
        lab.log("lint lab");
    }
}
