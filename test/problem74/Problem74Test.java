package problem74;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem74Test {

    @Test
    void getOrder() {
        Problem74 problem = new Problem74();

        assertArrayEquals(new int[]{0, 2, 3, 1}, problem.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}}));

        assertArrayEquals(new int[]{4, 3, 2, 0, 1}, problem.getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}}));
    }

    @Test
    void getOrderOptimized() {
        Problem74 problem = new Problem74();

        assertArrayEquals(new int[]{0, 2, 3, 1}, problem.getOrderOptimized(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}}));

        assertArrayEquals(new int[]{4, 3, 2, 0, 1}, problem.getOrderOptimized(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}}));

        assertArrayEquals(new int[]{5, 0, 1, 3, 2, 4}, problem.getOrderOptimized(new int[][]{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}}));
    }
}