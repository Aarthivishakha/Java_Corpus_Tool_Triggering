package com.pramora.testable.metrics;

/**
 * Loops, nested conditions, exception handlers, multi-function call chains and a
 * contradictory condition (a path that can never run). Data for the path coverage
 * metrics: partial paths, nested conditions, loop paths, unreachable paths,
 * exception paths and multi-function path tracking.
 */
public class PathLab {

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
        return v > -10 ? v : -10;
    }

    private int handlePositive(int v) {
        if (v > 100) {
            return 100;
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
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public int neverTrue(int x) {
        if (x > 10 && x < 5) {
            return -1;
        }
        return x;
    }

    public int loopPaths(int n) {
        int i = 0;
        int acc = 0;
        while (i < n) {
            if (i % 3 == 0) {
                acc += i;
            }
            i++;
        }
        return acc;
    }
}
