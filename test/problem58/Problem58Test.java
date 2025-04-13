package problem58;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem58Test {

    @Test
    void singleNumber() {
        Problem58 problem = new Problem58();

        assertEquals(3, problem.singleNumber(new int[]{2, 2, 3, 2}));
        assertEquals(99, problem.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}