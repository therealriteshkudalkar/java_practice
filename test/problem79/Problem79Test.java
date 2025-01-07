package problem79;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem79Test {

    @Test
    void sortColors() {
        Problem79 problem = new Problem79();

        int[] test1 = new int[]{2, 0, 2, 1, 1, 0};
        problem.sortColors(test1);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, test1);

        int[] test2 = new int[]{2, 0 , 1};
        problem.sortColors(test2);
        assertArrayEquals(new int[]{0, 1, 2}, test2);
    }
}