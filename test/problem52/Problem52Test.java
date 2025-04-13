package problem52;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem52Test {

    @Test
    void maxSlidingWindow() {
        Problem52 problem = new Problem52();

        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, problem.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        assertArrayEquals(new int[]{1}, problem.maxSlidingWindow(new int[]{1}, 1));

        assertArrayEquals(new int[]{3, 3}, problem.maxSlidingWindow(new int[]{1, 3, 2}, 2));
    }
}