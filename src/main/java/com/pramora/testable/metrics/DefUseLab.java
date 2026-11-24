package com.pramora.testable.metrics;

/**
 * Variables defined and used across branches, loops and helper calls. Data for the
 * data-flow metrics: definition-use mapping and pairs, multiple definitions,
 * cross-function uses, partial uses, and a definition that is never used.
 */
public class DefUseLab {

    public int definitions(int a, int b) {
        int x = a + 1;
        int y = b * 2;
        if (x > y) {
            x = x - y;
        } else {
            y = y - x;
        }
        int z = x + y;
        return z;
    }

    public int multipleDefs(int n) {
        int r = 0;
        r = n;
        r = r + 1;
        if (n > 5) {
            r = r * 2;
        }
        return r;
    }

    public int crossFunction(int n) {
        int base = helper(n);
        int result = base + helper(base);
        return result;
    }

    private int helper(int v) {
        int t = v * 3;
        return t - 1;
    }

    public int unusedDefinition(int n) {
        int dead = n * 7;
        int live = n + 1;
        dead = 0;
        return live;
    }

    public int loopUse(int[] xs) {
        int total = 0;
        for (int i = 0; i < xs.length; i++) {
            int cur = xs[i];
            if (cur > 0) {
                total += cur;
            }
        }
        return total;
    }
}
