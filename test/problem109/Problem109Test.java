package problem109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem109Test {

    @Test
    void maxScore() {
        Problem109 problem = new Problem109();

        // Test 1
        assertEquals(12, problem.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));

        // Test 2
        assertEquals(30, problem.maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1));

        // Test 3
        assertEquals(168, problem.maxScore(new int[]{2, 1, 14, 12}, new int[]{11, 7, 13, 6}, 3));
    }
}