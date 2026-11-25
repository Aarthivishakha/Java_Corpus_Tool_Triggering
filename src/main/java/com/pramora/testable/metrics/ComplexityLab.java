package com.pramora.testable.metrics;

/**
 * Branch-heavy rules with compound conditions. Data for the cyclomatic-complexity
 * metrics: decision coverage, condition coverage (MC/DC style), logic coverage and
 * maintainability. Each method is small enough to stay maintainable.
 */
public class ComplexityLab {

    // Named constants (checkstyle MagicNumber).
    private static final int N_10 = 10;
    private static final int N_3 = 3;
    private static final int N_30 = 30;
    private static final int N_5 = 5;
    private static final int N_500 = 500;
    private static final int N_65 = 65;

    public String shippingTier(int weightKg, boolean express, boolean fragile) {
        if (weightKg <= 0) {
            return "INVALID";
        }
        if (express && fragile) {
            return "EXPRESS_FRAGILE";
        }
        if (express || weightKg > N_30) {
            return "EXPRESS";
        }
        if (fragile) {
            return "CAREFUL";
        }
        return "STANDARD";
    }

    public boolean eligibleForDiscount(int age, boolean member, boolean coupon) {
        return (age >= N_65 || member) && !coupon;
    }

    public int loyaltyPoints(int spendDollars, boolean member, boolean firstOrder) {
        int points = spendDollars / N_10;
        if (member) {
            points = points * 2;
        } else if (firstOrder) {
            points = points + N_5;
        }
        if (points > N_500) {
            points = N_500;
        }
        return points;
    }

    public int decisionScore(boolean a, boolean b, boolean c) {
        int score = 0;
        if (a && (b || c)) {
            score += N_3;
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
