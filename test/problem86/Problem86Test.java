package problem86;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem86Test {

    @Test
    void findLongestChain() {
        Problem86 problem = new Problem86();

        assertEquals(2, problem.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));

        assertEquals(3, problem.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));

        assertEquals(2, problem.findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}}));

        assertEquals(4, problem.findLongestChain(new int[][]{{5, 7}, {-8, 2}, {-3, 7}, {-8, 9}, {-2, 1}, {-8, -5}, {-2, -1}, {2, 4}, {2, 6}}));
    }
}