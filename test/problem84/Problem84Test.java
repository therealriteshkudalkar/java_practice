package problem84;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem84Test {

    @Test
    void findPeakElement() {
        Problem84 problem = new Problem84();

        assertEquals(2, problem.findPeakElement(new int[]{1, 2, 3, 1}));

        assertEquals(5, problem.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}