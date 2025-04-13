package problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem32Test {

    @Test
    void maximumSubarraySumNaive() {
        Problem32 pb = new Problem32();

        assertEquals(11, pb.maximumSubarraySumNaive(new int[]{5, 3, 3}, 2));

        assertEquals(11, pb.maximumSubarraySumNaive(new int[]{1, 2, 3, 4, 5, 6}, 1));

        assertEquals(11, pb.maximumSubarraySumNaive(new int[]{-1, 3, 2, 4, 5}, 3));

        assertEquals(-6, pb.maximumSubarraySumNaive(new int[]{-1, -2, -3, -4}, 2));

        assertEquals(0, pb.maximumSubarraySumNaive(new int[]{1, 5}, 2));

        assertEquals(18999999810L, pb.maximumSubarraySumNaive(new int[]{999999980,999999981,999999982,999999983,999999984,999999985,999999986,999999987,999999988,999999989,999999990,999999991,999999992,999999993,999999994,999999995,999999996,999999997,999999998,999999999}, 18));
    }

    @Test
    void maximumSubarraySum() {
        Problem32 pb = new Problem32();

        assertEquals(11, pb.maximumSubarraySum(new int[]{5, 3, 3}, 2));

        assertEquals(11, pb.maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6}, 1));

        assertEquals(11, pb.maximumSubarraySum(new int[]{-1, 3, 2, 4, 5}, 3));

        assertEquals(-6, pb.maximumSubarraySum(new int[]{-1, -2, -3, -4}, 2));

        assertEquals(0, pb.maximumSubarraySum(new int[]{1, 5}, 2));

        assertEquals(18999999810L, pb.maximumSubarraySum(new int[]{999999980,999999981,999999982,999999983,999999984,999999985,999999986,999999987,999999988,999999989,999999990,999999991,999999992,999999993,999999994,999999995,999999996,999999997,999999998,999999999}, 18));

    }
}