package problem19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem19Test {

    @Test
    void rotate() {
        Problem19 pb = new Problem19();

        // Test 1
        int[][] matrix1 = new int[][]{{1, 2,}, {3, 4}};
        pb.rotateOptimized(matrix1);
        assertArrayEquals(new int[][]{{3, 1}, {4, 2}}, matrix1);

        // Test 2
        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        pb.rotateOptimized(matrix2);
        assertArrayEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, matrix2);
    }
}