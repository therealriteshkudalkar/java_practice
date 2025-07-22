package problem117;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem117Test {

    @Test
    void letterCasePermutation() {
        Problem117 problem = new Problem117();

        assertEquals(List.of("a1b2", "a1B2", "A1b2", "A1B2"), problem.letterCasePermutation("a1b2"));
        assertEquals(List.of("3z4", "3Z4"), problem.letterCasePermutation("3z4"));
    }
}