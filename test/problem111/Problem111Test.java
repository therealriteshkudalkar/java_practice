package problem111;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem111Test {

    @Test
    void medianSlidingWindow() {
        Problem111 problem111 = new Problem111();

        // Test1
        assertArrayEquals(new double[]{2.0, 3.0, 4.0, 5.0}, problem111.medianSlidingWindow(new int[]{1, 2, 3, 4, 5, 6}, 3));

        // Test 2
        assertArrayEquals(new double[]{1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000}, problem111.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}