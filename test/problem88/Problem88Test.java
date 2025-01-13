package problem88;

import org.junit.jupiter.api.Test;
import problem34.Problem34;

import static org.junit.jupiter.api.Assertions.*;

class Problem88Test {

    @Test
    void canTransform() {
        Problem88 problem = new Problem88();

        assertTrue(problem.canTransform("RXXLRXRXL", "XRLXXRRLX"));

        assertFalse(problem.canTransform("RL", "XR"));

        assertTrue(problem.canTransform("RXRXRRXL", "XRRXRRLX"));

        assertTrue(problem.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
}