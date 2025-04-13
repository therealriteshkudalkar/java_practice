package problem81;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem81Test {

    @Test
    void combinationSum() {
        Problem81 problem = new Problem81();

        List<List<Integer>> expectedResult1 = List.of(
                List.of(2, 2, 3),
                List.of(7)
        );
        assertEquals(expectedResult1, problem.combinationSum(new int[]{2, 3, 6, 7}, 7));

        List<List<Integer>> expectedResult2 = List.of(
                List.of(2, 3, 3),
                List.of(3, 5),
                List.of(2, 2, 2, 2)
        );
        assertEquals(expectedResult2, problem.combinationSum(new int[]{2, 3, 5}, 8));

        List<List<Integer>> expectedResults3 = List.of();
        assertEquals(expectedResults3, problem.combinationSum(new int[]{2}, 1));
    }
}