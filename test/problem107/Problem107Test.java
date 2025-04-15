package problem107;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem107Test {

    @Test
    void lastStoneWeight() {
        Problem107 problem = new Problem107();

        // Test 1
        assertEquals(1, problem.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));

        // Test 2
        assertEquals(1, problem.lastStoneWeight(new int[]{1}));
    }
}