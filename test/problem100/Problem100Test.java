package problem100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem100Test {

    @Test
    void getMinimumOfMaximumPathElevation() {
        Problem100 problem = new Problem100();

        // Test 1
        int[][] elevation1 = new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        assertEquals(4, problem.getMaximumOfMinimumPathElevation(elevation1));

        // Test 2
        int[][] elevation2 = new int[][]{{2, 2, 1, 2, 2, 2}, {1, 2, 2, 2, 1, 2}};
        assertEquals(2, problem.getMaximumOfMinimumPathElevation(elevation2));

        // Test 3
        int[][] elevation3 = new int[][]{{7, 6}, {2, 9}};
        assertEquals(6, problem.getMaximumOfMinimumPathElevation(elevation3));

        // Test 3
        int[][] elevation4 = new int[][]{{3, 4, 5}, {3, 2, 5}, {4, 2, 1}};
        assertEquals(1, problem.getMaximumOfMinimumPathElevation(elevation4));
    }
}