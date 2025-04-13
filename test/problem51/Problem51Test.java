package problem51;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem51Test {

    @Test
    void search() {
        Problem51 problem = new Problem51();

        assertEquals(4, problem.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));

        assertEquals(-1, problem.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

        assertEquals(-1, problem.search(new int[]{1}, 0));
    }
}