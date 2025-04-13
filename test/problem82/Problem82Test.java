package problem82;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem82Test {

    @Test
    void leastInterval() {
        Problem82 problem = new Problem82();

        //assertEquals(8, problem.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        //assertEquals(6, problem.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));
        assertEquals(8, problem.leastInterval(new char[]{'B', 'C', 'D', 'A', 'A', 'A', 'A', 'G'}, 1));
    }
}