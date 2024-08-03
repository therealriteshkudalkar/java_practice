package problem17;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem17Test {

    @Test
    void spiralOrder() {
        Problem17 pb = new Problem17();

        // Test 1
        int[][] matrix1 = new int[][]{{1, 2}, {3, 4}};
        assertEquals(Arrays.asList(1, 2, 4, 3), pb.spiralOrder(matrix1));

        // Test 2
        int[][] matrix2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5), pb.spiralOrder(matrix2));

        // Test 3
        int[][] matrix3 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10), pb.spiralOrder(matrix3));

        // Test 4
        int[][] matrix4 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        assertEquals(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), pb.spiralOrder(matrix4));
    }
}