package com.pramora.testable.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Deliberate lint and rule violations (unused variable, naming, style, complexity)
 * in one file, so lint tools report several violations at once. Also holds the
 * constructs a good rule set must NOT flag (false-positive prevention).
 */
public class LintLab {

    // Named constants (checkstyle MagicNumber).
    private static final int N_10 = 10;
    private static final int N_11 = 11;
    private static final int N_3 = 3;
    private static final int N_4 = 4;
    private static final int N_42 = 42;
    private static final int N_5 = 5;
    private static final int N_6 = 6;
    private static final int N_7 = 7;
    private static final int N_8 = 8;
    private static final int N_9 = 9;

    public static final int max_items = 10;

    public int Compute_total(int a, int b) {
        int unusedValue = N_42;
        int result=a+b;
        if (result > max_items) result = max_items;
        return result;
    }

    private final StringBuilder messages = new StringBuilder();

    /** Records a message instead of printing it, so the class has no console output. */
    public void log(String message) {
        messages.append(message).append('\n');
    }

    public String logged() {
        return messages.toString();
    }

    public String describe(int code) {
        if (code == 1) {
            return "one";
        }
        if (code == 2) {
            return "two";
        }
        if (code == N_3) {
            return "three";
        }
        if (code == N_4) {
            return "four";
        }
        if (code == N_5) {
            return "five";
        }
        if (code == N_6) {
            return "six";
        }
        if (code == N_7) {
            return "seven";
        }
        if (code == N_8) {
            return "eight";
        }
        if (code == N_9) {
            return "nine";
        }
        if (code == N_10) {
            return "ten";
        }
        if (code == N_11) {
            return "eleven";
        }
        return "many";
    }

    /** Looks like an unused name but is used: a correct rule set must not flag it. */
    public int usedDespiteName(int unused) {
        List<Integer> values = new ArrayList<>();
        values.add(unused);
        return values.get(0);
    }
}
