package problem7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void findMaxAverage() {
        Problem7 pb = new Problem7();
        assertEquals(12.75, pb.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        assertEquals(5.0, pb.findMaxAverage(new int[]{5}, 1));
    }
}