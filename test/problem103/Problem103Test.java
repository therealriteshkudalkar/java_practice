package problem103;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem103Test {

    @Test
    void findKthLargest() {
        Problem103 problem = new Problem103();

        assertEquals(5, problem.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, problem.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}