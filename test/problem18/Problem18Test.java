package problem18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem18Test {

    @Test
    void maxAreaBruteForce() {
        Problem18 pb = new Problem18();

        // Test 1
        assertEquals(1, pb.maxAreaBruteForce(new int[]{1, 1}));

        // Test 2
        assertEquals(49, pb.maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void maxArea() {
        Problem18 pb = new Problem18();

        // Test 1
        assertEquals(1, pb.maxArea(new int[]{1, 1}));

        // Test 2
        assertEquals(49, pb.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}