package com.pramora.testable.analysis;

import com.pramora.testable.model.LoyaltyTier;
import com.pramora.testable.model.Order;
import com.pramora.testable.model.OrderLine;

/**
 * Scores an order for manual-review risk. Nested conditionals here are intentional -
 * this is the fixture for cognitive complexity, which penalises nesting where
 * cyclomatic complexity does not.
 */
public class RiskScorer {

    // Named constants (checkstyle MagicNumber).
    private static final int N_10 = 10;
    private static final int N_100 = 100;
    private static final int N_15 = 15;
    private static final int N_20 = 20;
    private static final long N_200000 = 200000L;
    private static final int N_25 = 25;
    private static final int N_30 = 30;
    private static final int N_5 = 5;
    private static final int N_50 = 50;
    private static final long N_50000 = 50000L;

    public int score(Order order) {
        if (order == null) {
            return 0;
        }
        var score = 0;
        var customer = order.getCustomer();

        if (customer.getOrderCount() < 2) {
            score += N_30;
            if (order.subtotalCents() > N_50000) {
                score += N_25;
                if (customer.getTier() == LoyaltyTier.STANDARD) {
                    score += N_15;
                }
            }
        } else {
            if (order.subtotalCents() > N_200000) {
                score += N_20;
            }
        }

        for (OrderLine line : order.getLines()) {
            if (line.getQuantity() > N_50) {
                score += N_10;
            }
            if (line.getUnitPriceCents() == 0L) {
                score += N_5;
            }
        }

        return Math.min(score, N_100);
    }

    public boolean requiresReview(Order order) {
        return score(order) >= N_50;
    }
}
