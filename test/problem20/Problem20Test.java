package problem20;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem20Test {

    @Test
    void removeDuplicates() {
        Problem20 pb = new Problem20();

        // Test 1
        int[] nums1 = new int[]{1, 1, 2, 2, 3, 4, 4, 5};
        assertEquals(5, pb.removeDuplicates(nums1));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 5, 5, 5}, nums1);

        // Test 2
        int[] nums2 = new int[]{1, 1, 2};
        assertEquals(2, pb.removeDuplicates(nums2));
        assertArrayEquals(new int[]{1, 2, 2}, nums2);
    }

    @Test
    void removeDuplicatesOptimized() {
        Problem20 pb = new Problem20();

        // Test 1
        int[] nums1 = new int[]{1, 1, 2, 2, 3, 4, 4, 5};
        assertEquals(5, pb.removeDuplicatesOptimized(nums1));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 4, 4, 5}, nums1);

        // Test 2
        int[] nums2 = new int[]{1, 1, 2};
        assertEquals(2, pb.removeDuplicatesOptimized(nums2));
        assertArrayEquals(new int[]{1, 2, 2}, nums2);
    }
}