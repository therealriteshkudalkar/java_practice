package problem71;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem71Test {
    @Test
    void medianFinder() {
        Problem71.MedianFinder problem = new Problem71.MedianFinder();
        problem.addNum(1);
        assertEquals(1.0, problem.findMedian());
        problem.addNum(2);
        assertEquals(1.5, problem.findMedian());
        problem.addNum(3);
        assertEquals(2.0, problem.findMedian());
        problem.addNum(1);
        assertEquals(1.5, problem.findMedian());
        problem.addNum(4);
        assertEquals(2, problem.findMedian());
        problem.addNum(0);
        assertEquals(1.5, problem.findMedian());

        Problem71.MedianFinder problem1 = new Problem71.MedianFinder();
        problem1.addNum(-1);
        assertEquals(-1.0, problem1.findMedian());
        problem1.addNum(-2);
        assertEquals(-1.5, problem1.findMedian());
        problem1.addNum(-3);
        assertEquals(-2.0, problem1.findMedian());
    }
}