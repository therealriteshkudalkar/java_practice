package problem12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem12Test {

    @Test
    void merge() {
        Problem12 pb = new Problem12();

        // Test 1
        int[][] array1 = new int[][]{
          new int[]{1, 3},
          new int[]{2, 6},
          new int[]{8, 10},
          new int[]{15, 18}
        };
        assertArrayEquals(new int[][]{
                new int[]{1, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        }, pb.merge(array1));

        // Test 2
        int[][] array2 = new int[][]{
                new int[]{1, 4},
                new int[]{4, 5}
        };
        assertArrayEquals(new int[][]{
                new int[]{1, 5}
        }, pb.merge(array2));
    }
}