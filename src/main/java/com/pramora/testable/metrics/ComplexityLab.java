package com.pramora.testable.metrics;

/**
 * Branch-heavy rules with compound conditions. Data for the cyclomatic-complexity
 * metrics: decision coverage, condition coverage (MC/DC style), logic coverage and
 * maintainability. Each method is small enough to stay maintainable.
 */
public class ComplexityLab {

    public String shippingTier(int weightKg, boolean express, boolean fragile) {
        if (weightKg <= 0) {
            return "INVALID";
        }
        if (express && fragile) {
            return "EXPRESS_FRAGILE";
        }
        if (express || weightKg > 30) {
            return "EXPRESS";
        }
        if (fragile) {
            return "CAREFUL";
        }
        return "STANDARD";
    }

    public boolean eligibleForDiscount(int age, boolean member, boolean coupon) {
        return (age >= 65 || member) && !coupon;
    }

    public int loyaltyPoints(int spendDollars, boolean member, boolean firstOrder) {
        int points = spendDollars / 10;
        if (member) {
            points = points * 2;
        } else if (firstOrder) {
            points = points + 5;
        }
        if (points > 500) {
            points = 500;
        }
        return points;
    }

    public int decisionScore(boolean a, boolean b, boolean c) {
        int score = 0;
        if (a && (b || c)) {
            score += 3;
        }
        if (a ^ b) {
            score += 2;
        }
        if (!a && !b && !c) {
            score += 1;
        }
        return score;
    }
}
