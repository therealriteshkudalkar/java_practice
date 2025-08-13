package problem23;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Problem23Test {

    @Test
    void fourSum() {
        Problem23 pb = new Problem23();

        // Test 1
        int[] nums1 = new int[]{1, 0, -1, 0, -2, 2};

        assertTrue(Set.of(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        ).containsAll(Set.of(pb.fourSum(nums1, 0))));

        // assertNotEquals(0, new HashSet<>(Set.of(pb.fourSum(nums1, 0))).retainAll(new HashSet<>()));
    }

    @Test
    void fourSumOptimized() {
    }
}