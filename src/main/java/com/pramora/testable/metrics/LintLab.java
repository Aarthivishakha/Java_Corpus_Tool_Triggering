package com.pramora.testable.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Deliberate lint and rule violations (unused variable, naming, style, complexity)
 * in one file, so lint tools report several violations at once. Also holds the
 * constructs a good rule set must NOT flag (false-positive prevention).
 */
public class LintLab {

    public static final int max_items = 10;

    public int Compute_total(int a, int b) {
        int unusedValue = 42;
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
        if (code == 3) {
            return "three";
        }
        if (code == 4) {
            return "four";
        }
        if (code == 5) {
            return "five";
        }
        if (code == 6) {
            return "six";
        }
        if (code == 7) {
            return "seven";
        }
        if (code == 8) {
            return "eight";
        }
        if (code == 9) {
            return "nine";
        }
        if (code == 10) {
            return "ten";
        }
        if (code == 11) {
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
