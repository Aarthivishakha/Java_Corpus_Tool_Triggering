package com.pramora.testable.service;

import com.pramora.testable.model.Customer;
import com.pramora.testable.model.LoyaltyTier;
import com.pramora.testable.model.Order;

/** Computes the discount applied to an order, in cents. */
public class DiscountPolicy {

    // Named constants (checkstyle MagicNumber).
    private static final long N_100 = 100L;
    private static final int N_20 = 20;
    private static final int N_3 = 3;

    private static final long LOYALTY_ORDER_BONUS_THRESHOLD = 25L;

    public long discountCents(Order order) {
        if (order == null) {
            return 0L;
        }
        Customer customer = order.getCustomer();
        int percent = customer.getTier().getDiscountPercent();

        if (customer.getOrderCount() >= LOYALTY_ORDER_BONUS_THRESHOLD) {
            percent = percent + 2;
        }
        if (customer.getTier() == LoyaltyTier.STANDARD && customer.getOrderCount() < N_3) {
            percent = 0;
        }
        if (percent > N_20) {
            percent = N_20;
        }
        if (percent <= 0) {
            return 0L;
        }
        return (order.subtotalCents() * percent) / N_100;
    }
}
