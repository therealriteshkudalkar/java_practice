package problem92;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem92Test {

    @Test
    void numOfArrays() {
        Problem92 problem = new Problem92();

        assertEquals(6, problem.numOfArrays(2, 3, 1));
        assertEquals(34549172, problem.numOfArrays(50, 100, 25));
    }
}