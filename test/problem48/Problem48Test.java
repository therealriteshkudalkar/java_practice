package problem48;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem48Test {

    @Test
    void mySqrtNaive() {
        Problem48 prob = new Problem48();
        assertEquals(1, prob.mySqrtNaive(2));
        assertEquals(2, prob.mySqrtNaive(4));
        assertEquals(2, prob.mySqrtNaive(8));
        assertEquals(3, prob.mySqrtNaive(9));
        assertEquals(8, prob.mySqrtNaive(80));
    }

    @Test
    void mySqrtOptimized() {
        Problem48 prob = new Problem48();
        assertEquals(1, prob.mySqrtOptimized(2));
        assertEquals(2, prob.mySqrtOptimized(4));
        assertEquals(2, prob.mySqrtOptimized(8));
        assertEquals(3, prob.mySqrtOptimized(9));
        assertEquals(8, prob.mySqrtOptimized(80));
        assertEquals(46339, prob.mySqrtOptimized(2147395599));
    }
}