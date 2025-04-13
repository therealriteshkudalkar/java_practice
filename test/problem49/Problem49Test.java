package problem49;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem49Test {

    @Test
    void searchRange() {
        Problem49 problem = new Problem49();

        assertArrayEquals(new int[]{3, 4}, problem.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));

        assertArrayEquals(new int[]{-1, -1}, problem.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}