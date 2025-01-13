package problem93;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem93Test {

    @Test
    void maxBalancedSubsequenceSum() {
        Problem93 problem = new Problem93();

        assertEquals(14, problem.maxBalancedSubsequenceSum(new int[]{3, 3, 5, 6}));

        assertEquals(13, problem.maxBalancedSubsequenceSum(new int[]{5, -1, -3, 8}));

        assertEquals(-1, problem.maxBalancedSubsequenceSum(new int[]{-1, -2}));
    }
}