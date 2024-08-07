package problem22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem22Test {

    @Test
    void numPairsDivisibleBy60() {
        Problem22 pb = new Problem22();

        // Test 1
        int[] time1 = new int[]{30, 20, 150, 100, 40};
        assertEquals(3, pb.numPairsDivisibleBy60(time1));

        // Test 2
        int[] time2 = new int[]{60, 60, 60};
        assertEquals(3, pb.numPairsDivisibleBy60(time2));
    }

    @Test
    void numPairsDivisibleBy60Optimized() {
        Problem22 pb = new Problem22();

        // Test 1
        int[] time1 = new int[]{30, 20, 150, 100, 40};
        assertEquals(3, pb.numPairsDivisibleBy60Optimized(time1));

        // Test 2
        int[] time2 = new int[]{60, 60, 60};
        assertEquals(3, pb.numPairsDivisibleBy60Optimized(time2));
    }
}