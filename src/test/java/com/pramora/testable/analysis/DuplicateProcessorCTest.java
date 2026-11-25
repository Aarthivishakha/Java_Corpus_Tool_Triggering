package com.pramora.testable.analysis;

import static org.junit.Assert.assertEquals;

import com.pramora.testable.model.Customer;
import com.pramora.testable.model.LoyaltyTier;
import com.pramora.testable.model.Order;
import com.pramora.testable.model.OrderLine;
import org.junit.Test;

public class DuplicateProcessorCTest {

    private Order order(int qty, long unitCents) {
        Order o = new Order("O-2", new Customer("C-2", "Test", LoyaltyTier.SILVER, 5));
        o.addLine(new OrderLine("SKU-2", qty, unitCents));
        return o;
    }

    @Test
    public void allThreeProcessorsAgree() {
        Order o = order(3, 777L);
        long a = new DuplicateProcessorA().process(o);
        assertEquals(a, new DuplicateProcessorB().process(o));
        assertEquals(a, new DuplicateProcessorC().process(o));
    }

    @Test
    public void nullOrderIsZero() {
        assertEquals(0L, new DuplicateProcessorC().process(null));
    }
}
