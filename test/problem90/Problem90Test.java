package problem90;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem90Test {

    @Test
    void numRescueBoats() {
        Problem90 problem = new Problem90();

        assertEquals(1, problem.numRescueBoats(new int[]{1, 2}, 3));

        assertEquals(3, problem.numRescueBoats(new int[]{3, 2, 2, 1}, 3));

        assertEquals(4, problem.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}