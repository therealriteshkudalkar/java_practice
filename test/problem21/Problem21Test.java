package problem21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem21Test {

    @Test
    void gameOfLife() {
        Problem21 pb = new Problem21();

        // Test 1
        int[][] board1 = new int[][]{{1, 1}, {1, 0}};
        pb.gameOfLife(board1);
        assertArrayEquals(new int[][]{{1, 1}, {1, 1}}, board1);

        // Test 2
        int[][] board2 = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        pb.gameOfLife(board2);
        assertArrayEquals(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}, board2);
    }

    @Test
    void gameOfLifeOptimized() {
        Problem21 pb = new Problem21();

        // Test 1
        int[][] board1 = new int[][]{{1, 1}, {1, 0}};
        pb.gameOfLifeOptimized(board1);
        assertArrayEquals(new int[][]{{1, 1}, {1, 1}}, board1);

        // Test 2
        int[][] board2 = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        pb.gameOfLifeOptimized(board2);
        assertArrayEquals(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}, board2);
    }
}