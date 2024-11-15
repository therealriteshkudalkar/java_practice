package problem28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem28Test {

    @Test
    void calculateMinimumCost() {
        Problem28 pb = new Problem28();

        assertEquals(10, pb.calculateMinimumCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        assertEquals(2, pb.calculateMinimumCost(new int[][]{{7, 6, 2}}));
        assertEquals(5, pb.calculateMinimumCost(new int[][]{{1, 3}, {2, 4}}));
        assertEquals(5, pb.calculateMinimumCost(new int[][]{{1, 5, 3}, {2, 9, 4}}));
    }
}