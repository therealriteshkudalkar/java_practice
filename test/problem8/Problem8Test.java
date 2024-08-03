package problem8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void maxSubArray() {
        Problem8 pb = new Problem8();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        assertEquals(2, pb.subarraySum(nums, k));
    }

    @Test
    void maxSubArray1() {
        Problem8 pb = new Problem8();
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        assertEquals(2, pb.subarraySum(nums, k));
    }

    @Test
    void maxSubArray2() {
        Problem8 pb = new Problem8();
        int[] nums = new int[]{-1, -4, 0, 5, 3, 2, 1};
        int k = 5;
        assertEquals(3, pb.subarraySum(nums, k));
    }
}