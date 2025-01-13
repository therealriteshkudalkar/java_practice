package problem83;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem83Test {

    @Test
    void maxAlternatingSum() {
        Problem83 problem = new Problem83();

        assertEquals(7, problem.maxAlternatingSum(new int[]{4, 2, 5, 3}));
        assertEquals(8, problem.maxAlternatingSum(new int[]{5, 6, 7, 8}));
        assertEquals(10, problem.maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5}));
    }
}