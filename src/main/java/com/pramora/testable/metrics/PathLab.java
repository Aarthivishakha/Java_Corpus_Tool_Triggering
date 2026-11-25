package com.pramora.testable.metrics;

/**
 * Loops, nested conditions, exception handlers, multi-function call chains and a
 * contradictory condition (a path that can never run). Data for the path coverage
 * metrics: partial paths, nested conditions, loop paths, unreachable paths,
 * exception paths and multi-function path tracking.
 */
public class PathLab {

    // Named constants (checkstyle MagicNumber).
    private static final int NEG_10 = -10;
    private static final int N_10 = 10;
    private static final int N_12 = 12;
    private static final int N_100 = 100;
    private static final int N_3 = 3;

    public int process(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        int sum = 0;
        for (int v : data) {
            if (v < 0) {
                sum += handleNegative(v);
            } else if (v == 0) {
                continue;
            } else {
                sum += handlePositive(v);
            }
        }
        return wrapUp(sum);
    }

    private int handleNegative(int v) {
        return v > NEG_10 ? v : NEG_10;
    }

    private int handlePositive(int v) {
        if (v > N_100) {
            return N_100;
        }
        return v;
    }

    private int wrapUp(int sum) {
        return sum < 0 ? 0 : sum;
    }

    public int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }

    public int nested(int a, int b, int c) {
        if (a > 0) {
            if (b > 0) {
                if (c > 0) {
                    return N_3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    /** -1 only inside the narrow window 10 < x < 12; every other input is returned unchanged. */
    public int narrowWindow(int x) {
        if (x > N_10 && x < N_12) {
            return -1;
        }
        return x;
    }

    public int loopPaths(int n) {
        int i = 0;
        int acc = 0;
        while (i < n) {
            if (i % N_3 == 0) {
                acc += i;
            }
            i++;
        }
        return acc;
    }
}
