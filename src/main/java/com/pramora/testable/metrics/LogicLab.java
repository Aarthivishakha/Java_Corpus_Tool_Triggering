package com.pramora.testable.metrics;

/**
 * Small boundary-sensitive functions. Data for statement coverage (test completeness)
 * and branch coverage (logic error detection): off-by-one mutations on the boundaries
 * are only caught by tests that assert exact edge values.
 */
public class LogicLab {

    // Named constants (checkstyle MagicNumber).
    private static final int N_100 = 100;
    private static final int N_11 = 11;
    private static final int N_12 = 12;
    private static final int N_28 = 28;
    private static final int N_29 = 29;
    private static final int N_30 = 30;
    private static final int N_31 = 31;
    private static final int N_4 = 4;
    private static final int N_400 = 400;
    private static final int N_6 = 6;
    private static final int N_70 = 70;
    private static final int N_80 = 80;
    private static final int N_9 = 9;
    private static final int N_90 = 90;

    public int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public boolean isLeapYear(int year) {
        if (year % N_400 == 0) {
            return true;
        }
        if (year % N_100 == 0) {
            return false;
        }
        return year % N_4 == 0;
    }

    public String grade(int score) {
        if (score >= N_90) {
            return "A";
        }
        if (score >= N_80) {
            return "B";
        }
        if (score >= N_70) {
            return "C";
        }
        return "F";
    }

    public int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? N_29 : N_28;
            case N_4:
            case N_6:
            case N_9:
            case N_11:
                return N_30;
            default:
                if (month < 1 || month > N_12) {
                    return -1;
                }
                return N_31;
        }
    }
}
