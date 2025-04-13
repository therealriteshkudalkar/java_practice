package problem104;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem104Test {

    @Test
    void kClosest() {
        Problem104 problem = new Problem104();

        // Test 1
        assertArrayEquals(new int[][]{{-2, 2}}, problem.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));

        // Test 2
        assertArrayEquals(new int[][]{{-2, 4}, {3, 3}}, problem.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }
}