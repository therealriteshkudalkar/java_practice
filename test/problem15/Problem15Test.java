package problem15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem15Test {

    @Test
    void subarraySumNaive() {
        Problem15 pb = new Problem15();

        // Test 1
        int[] nums1 = new int[]{1, 1, 1};
        int k1 = 2;
        assertEquals(2, pb.subarraySumNaive(nums1, k1));

        // Test 2
        int[] nums2 = new int[]{1, 2, 3};
        int k2 = 3;
        assertEquals(2, pb.subarraySumNaive(nums2, k2));
    }

    @Test
    void subarraySumOptimized() {
        Problem15 pb = new Problem15();

        // Test 1
        int[] nums1 = new int[]{1, 1, 1};
        int k1 = 2;
        assertEquals(2, pb.subarraySumOptimized(nums1, k1));

        // Test 2
        int[] nums2 = new int[]{1, 2, 3};
        int k2 = 3;
        assertEquals(2, pb.subarraySumOptimized(nums2, k2));

        //Test 3
        int[] nums3 = new int[]{1, 5, 3, 4, 2, 2};
        int k3 = 4;
        assertEquals(2, pb.subarraySumOptimized(nums3, k3));
    }

    @Test
    void subarraySumHighlyOptimized() {
        Problem15 pb = new Problem15();

        // Test 1
        int[] nums1 = new int[]{1, 1, 1};
        int k1 = 2;
        assertEquals(2, pb.subarraySumHighlyOptimized(nums1, k1));

        // Test 2
        int[] nums2 = new int[]{1, 2, 3};
        int k2 = 3;
        assertEquals(2, pb.subarraySumHighlyOptimized(nums2, k2));

        //Test 3
        int[] nums3 = new int[]{1, 5, 3, 4, 2, 2};
        int k3 = 4;
        assertEquals(2, pb.subarraySumHighlyOptimized(nums3, k3));

        //Test 4
        int[] nums4 = new int[]{2, 5, -7, 3, 4, 3, 4, -7, 2, 5};
        int k4 = 7;
        assertEquals(12, pb.subarraySumHighlyOptimized(nums4, k4));
    }
}