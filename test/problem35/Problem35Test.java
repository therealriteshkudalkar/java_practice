package problem35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem35Test {

    @Test
    void lengthOfLIS() {
        Problem35 pb = new Problem35();

        assertEquals(5, pb.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));

        assertEquals(4, pb.lengthOfLIS(new int[]{7, 4, 5, 1, 8, 12, 4, 7}, 5));

        assertEquals(1, pb.lengthOfLIS(new int[]{1, 5}, 1));
    }
}