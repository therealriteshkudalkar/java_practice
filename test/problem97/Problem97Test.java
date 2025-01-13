package problem97;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem97Test {

    @Test
    void minEatingSpeed() {
        Problem97 problem = new Problem97();

        assertEquals(4, problem.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));

        assertEquals(30, problem.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }
}