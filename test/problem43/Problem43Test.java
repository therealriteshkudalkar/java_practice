package problem43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem43Test {

    @Test
    void climbStairs() {
        Problem43 pb = new Problem43();

        assertEquals(2, pb.climbStairs(2));

        assertEquals(3, pb.climbStairs(3));

        assertEquals(5, pb.climbStairs(4));
    }

    @Test
    void climbStairsOptimized() {
        Problem43 pb = new Problem43();

        assertEquals(2, pb.climbStairsOptimized(2));

        assertEquals(3, pb.climbStairsOptimized(3));

        assertEquals(5, pb.climbStairsOptimized(4));
    }
}