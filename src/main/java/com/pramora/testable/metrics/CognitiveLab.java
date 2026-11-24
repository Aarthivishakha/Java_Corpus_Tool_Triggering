package com.pramora.testable.metrics;

/**
 * Deeply nested control flow, labelled breaks and recursion. Data for the cognitive
 * complexity metrics: risk detection, code review support, testing effort
 * prioritization and code understandability.
 */
public class CognitiveLab {

    public int scoreMatrix(int[][] grid, int threshold) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > threshold) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            total += grid[i][j];
                        } else {
                            total -= 1;
                        }
                    } else if (j > 0 && grid[i][j - 1] > threshold) {
                        total += 2;
                    }
                } else if (grid[i][j] < 0) {
                    continue;
                }
            }
        }
        return total;
    }

    public int findFirstPair(int[] values, int target) {
        outer:
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] + values[j] == target) {
                    return i * 100 + j;
                }
                if (values[i] + values[j] > target * 4) {
                    break outer;
                }
            }
        }
        return -1;
    }

    public int collatzSteps(int n) {
        if (n <= 1) {
            return 0;
        }
        return 1 + collatzSteps(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }
}
