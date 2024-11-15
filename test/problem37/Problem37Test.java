package problem37;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem37Test {

    @Test
    void findMaxLength() {
        Problem37 pb = new Problem37();
        assertEquals(2, pb.findMaxLength(new int[]{0, 1}));
        assertEquals(2, pb.findMaxLength(new int[]{0, 1, 0}));
        assertEquals(6, pb.findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0}));
    }

    @Test
    void findMaxLengthOptimized() {
        Problem37 pb = new Problem37();
        assertEquals(2, pb.findMaxLengthOptimized(new int[]{0, 1}));
        assertEquals(2, pb.findMaxLengthOptimized(new int[]{0, 1, 0}));
        assertEquals(6, pb.findMaxLengthOptimized(new int[]{0, 0, 0, 1, 1, 1, 0}));
    }
}