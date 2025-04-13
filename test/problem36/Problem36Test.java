package problem36;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem36Test {
    @Test
    void rangeQueries() {
        Problem36.NumArray pb = new Problem36.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, pb.sumRange(0, 2));
        assertEquals(-1, pb.sumRange(2, 5));
        assertEquals(-3, pb.sumRange(0, 5));
    }
}