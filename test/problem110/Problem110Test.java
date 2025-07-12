package problem110;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem110Test {

    @Test
    void calculate() {
        Problem110 problem = new Problem110();

        // Test 1
        assertEquals(2, problem.calculate("1 + 1"));

        // Test 2
        assertEquals(131, problem.calculate("111 + ( 21 - 1 )"));

        // Test 3
        assertEquals(3, problem.calculate("2-1 + 2"));

        // Test 4
        assertEquals(9, problem.calculate("1 + 2 + (3 + 4 - 7) + 6"));

        // Test 5
        assertEquals(23, problem.calculate("(1+(4+5+2)-3)+(6+8)"));

        // Test 6
        assertEquals(-4, problem.calculate("1-(   3+ 2)"));

        // Test 7
        assertEquals(3, problem.calculate("1-(  -2)"));
    }
}