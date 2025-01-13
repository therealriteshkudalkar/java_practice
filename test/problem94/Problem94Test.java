package problem94;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem94Test {

    @Test
    void maximumBags() {
        Problem94 problem = new Problem94();

        assertEquals(3, problem.maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));

        assertEquals(3, problem.maximumBags(new int[]{10, 2, 2}, new int[]{2, 2, 0}, 100));
    }
}