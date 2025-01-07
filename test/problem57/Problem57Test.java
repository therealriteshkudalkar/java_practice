package problem57;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem57Test {

    @Test
    void singleNumber() {
        Problem57 problem = new Problem57();

        assertEquals(1, problem.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, problem.singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, problem.singleNumber(new int[]{1}));
    }
}