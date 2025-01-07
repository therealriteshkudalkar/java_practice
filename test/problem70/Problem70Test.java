package problem70;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem70Test {

    @Test
    void orangesRotting() {
        Problem70 problem = new Problem70();

        assertEquals(4, problem.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));

        assertEquals(-1, problem.orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));

        assertEquals(0, problem.orangesRotting(new int[][]{{0, 2}}));

        assertEquals(0, problem.orangesRotting(new int[][]{{0}}));
    }
}