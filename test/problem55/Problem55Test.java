package problem55;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem55Test {

    @Test
    void uniquePaths() {
        Problem55 problem = new Problem55();

        assertEquals(3, problem.uniquePaths(3, 2));

        assertEquals(28, problem.uniquePaths(3, 7));
    }
}