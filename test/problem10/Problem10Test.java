package problem10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem10Test {

    @Test
    void twoSum1() {
        Problem10 pb = new Problem10();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        assertArrayEquals(new int[]{1, 2}, pb.twoSum(numbers, target));
    }

    @Test
    void twoSum2() {
        Problem10 pb = new Problem10();
        int[] numbers = new int[]{2, 3, 4};
        int target = 6;

        assertArrayEquals(new int[]{1, 3}, pb.twoSum(numbers, target));
    }

    @Test
    void twoSum3() {
        Problem10 pb = new Problem10();
        int[] numbers = new int[]{-1, 0};
        int target = -1;

        assertArrayEquals(new int[]{1, 2}, pb.twoSum(numbers, target));
    }
}