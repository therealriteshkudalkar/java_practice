package problem13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem13Test {

    @Test
    void productExceptSelf() {
        Problem13 pb = new Problem13();

        // Test 1
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] result1 = new int[]{24, 12, 8, 6};
        assertArrayEquals(result1, pb.productExceptSelf(nums1));

        // Test 2
        int[] nums2 = new int[]{-1, 1, 0, -3, 3};
        int[] result2 = new int[]{0, 0, 9, 0, 0};
        assertArrayEquals(result2, pb.productExceptSelf(nums2));
    }

    @Test
    void productExceptSelfOptimized() {
        Problem13 pb = new Problem13();

        // Test 1
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] result1 = new int[]{24, 12, 8, 6};
        assertArrayEquals(result1, pb.productExceptSelfOptimized(nums1));

        // Test 2
        int[] nums2 = new int[]{-1, 1, 0, -3, 3};
        int[] result2 = new int[]{0, 0, 9, 0, 0};
        assertArrayEquals(result2, pb.productExceptSelfOptimized(nums2));
    }
}