package problem24;

import org.junit.jupiter.api.Test;
import problem21.Problem21;

import static org.junit.jupiter.api.Assertions.*;

class Problem24Test {

    @Test
    void coinChange() {
        Problem24 pb = new Problem24();

        // Test 1
        int[] coins1 = new int[]{1, 2, 5};
        int amount1 = 11;
        assertEquals(3, pb.coinChange(coins1, amount1));

        // Test 2
        int[] coins2 = new int[]{2};
        int amount2 = 3;
        assertEquals(-1, pb.coinChange(coins2, amount2));

        // Test 3
        int[] coins3 = new int[]{1};
        int amount3 = 0;
        assertEquals(0, pb.coinChange(coins3, amount3));

        // Test 4
        int[] coins4 = new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount4 = 9864;
        assertEquals(24, pb.coinChange(coins4, amount4));

        // Test 5
        int[] coins5 = new int[]{137, 38, 18, 497, 97, 462, 400, 119, 479, 416};
        int amount5 = 4605;
        assertEquals(10, pb.coinChange(coins5, amount5));
    }
}