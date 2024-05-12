package problem7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void findMaxAverage() {
        Problem7 pb = new Problem7();
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        assertEquals(12.75, pb.findMaxAverage(nums, k));
    }

    @Test
    void findMaxAverage1() {
        Problem7 pb = new Problem7();
        int[] nums = new int[]{5};
        int k = 1;
        assertEquals(5.0, pb.findMaxAverage(nums, k));
    }
}