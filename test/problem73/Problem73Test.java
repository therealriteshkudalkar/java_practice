package problem73;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem73Test {

    @Test
    void minStoneSum() {
        Problem73 problem = new Problem73();

        assertEquals(12, problem.minStoneSum(new int[]{5, 4, 9}, 2));
        assertEquals(12, problem.minStoneSum(new int[]{4, 3, 6, 7}, 3));
    }
}