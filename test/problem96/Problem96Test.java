package problem96;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem96Test {

    @Test
    public void testRandomIndexWithWeight() {
        Problem96.Solution1 problem1 = new Problem96.Solution1(new int[]{1, 9});
        assertEquals(1, problem1.pickIndex());
    }
}