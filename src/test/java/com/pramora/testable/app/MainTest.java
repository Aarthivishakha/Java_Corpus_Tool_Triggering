package com.pramora.testable.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MainTest {

    @Test
    public void summaryUsesTheGivenReference() {
        String text = Main.summary("O-77");
        assertTrue(text.contains("order      : O-77"));
        assertTrue(text.contains("lines      : 2"));
    }

    @Test
    public void summaryFallsBackToTheDemoReference() {
        assertTrue(Main.summary(null).contains("order      : O-DEMO"));
        assertTrue(Main.summary("").contains("order      : O-DEMO"));
    }
}
