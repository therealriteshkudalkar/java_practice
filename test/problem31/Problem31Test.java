package problem31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class Problem31Test {

    @Test
    void canSortArray() {
        Problem31 pb = new Problem31();

        assertTrue(pb.canSortArray(new int[]{8, 4, 2, 30, 15}));

        assertTrue(pb.canSortArray(new int[]{1, 2, 3, 4, 5}));

        assertFalse(pb.canSortArray(new int[]{3, 16, 8, 4, 2}));

        assertTrue(pb.canSortArray(new int[]{}));

        assertFalse(pb.canSortArray(new int[]{1, 3, 7, 31, 63, 15}));
    }
}