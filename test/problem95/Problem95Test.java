package problem95;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem95Test {

    @Test
    void longestCommonSubsequence() {
        Problem95 problem = new Problem95();

        assertEquals(3, problem.longestCommonSubsequence("abcde", "ace"));

        assertEquals(3, problem.longestCommonSubsequence("abc", "abc"));

        assertEquals(0, problem.longestCommonSubsequence("abc", "def"));
    }

    @Test
    void printLongestCommonSubsequence() {
        Problem95 problem = new Problem95();

        assertEquals("ace", problem.printLongestCommonSubsequence("abcde", "ace"));

        assertEquals("abc", problem.printLongestCommonSubsequence("abc", "abcd"));

        assertEquals("", problem.printLongestCommonSubsequence("abc", "def"));
    }
}