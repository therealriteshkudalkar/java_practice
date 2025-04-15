package problem108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem108Test {

    @Test
    void topKFrequent() {
        Problem108 problem = new Problem108();

        // Test 1
        assertArrayEquals(new int[]{1, 2}, problem.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));

        // Test 2
        assertArrayEquals(new int[]{1}, problem.topKFrequent(new int[]{1},1));
    }
}