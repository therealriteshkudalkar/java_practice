package problem60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem60Test {

    @Test
    void validPath() {
        Problem60 problem = new Problem60();

        assertTrue(problem.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        assertFalse(problem.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        assertTrue(problem.validPath(1, new int[][]{}, 0, 0));
        assertFalse(problem.validPath(200000, new int[][]{{0, 3390}, {199998, 199999}}, 0, 199999));
    }
}