package problem23;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem23Test {

    @Test
    void fourSum() {
        Problem23 pb = new Problem23();

        // Test 1
        int[] nums1 = new int[]{1, 0, -1, 0, -2, 2};
        assertThat(pb.fourSum(nums1, 0), CoreMatchers.hasItems(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        ));
    }

    @Test
    void fourSumOptimized() {
    }
}