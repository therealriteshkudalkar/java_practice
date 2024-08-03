package problem16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem16Test {

    @Test
    void nextPermutation() {
        Problem16 pb = new Problem16();

        // Test 1
        int[] nums1 = new int[]{1, 5, 6, 4, 3, 2};
        pb.nextPermutation(nums1);
        assertArrayEquals(new int[]{1, 6, 2, 3, 4, 5}, nums1);

        // Test 2
        int[] nums2 = new int[]{5, 3, 6, 7, 4, 2, 1};
        pb.nextPermutation(nums2);
        assertArrayEquals(new int[]{5, 3, 7, 1, 2, 4, 6}, nums2);

        // Test 3
        int[] nums3 = new int[]{1, 1, 5};
        pb.nextPermutation(nums3);
        assertArrayEquals(new int[]{1, 5, 1}, nums3);

        // Test 4
        int[] nums4 = new int[]{3, 2, 1};
        pb.nextPermutation(nums4);
        assertArrayEquals(new int[]{1, 2, 3}, nums4);

        // Test 5
        int[] nums5 = new int[]{1, 5, 1};
        pb.nextPermutation(nums5);
        assertArrayEquals(new int[]{5, 1, 1}, nums5);
    }
}