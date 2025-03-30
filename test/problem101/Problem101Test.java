package problem101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem101Test {

    @Test
    void swimInWater() {
        Problem101 problem = new Problem101();

        // Test 1
        int[][] grid1 = new int[][]{{0, 2}, {1, 3}};
        assertEquals(3, problem.swimInWater(grid1));

        // Test 2
        int[][] grid2 = new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        assertEquals(16, problem.swimInWater(grid2));
    }
}