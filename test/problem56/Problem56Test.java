package problem56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem56Test {

    @Test
    void uniquePathsWithObstacles() {
        Problem56 problem = new Problem56();

        assertEquals(2, problem.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(1, problem.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        assertEquals(0, problem.uniquePathsWithObstacles(new int[][]{{1, 0}}));
        assertEquals(0, problem.uniquePathsWithObstacles(new int[][]{{1}}));
    }
}