package problem76;

import org.junit.jupiter.api.Test;
import problem72.Problem72;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem76Test {

    @Test
    void subsets() {
        Problem76 problem = new Problem76();

        List<List<Integer>> expectedSubsets = List.of(
                List.of(1, 2, 3),
                List.of(1, 2),
                List.of(1, 3),
                List.of(1),
                List.of(2, 3),
                List.of(2),
                List.of(3),
                List.of()
        );
        assertEquals(expectedSubsets, problem.subsets(new int[]{1, 2, 3}));
    }
}