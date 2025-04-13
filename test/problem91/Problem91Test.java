package problem91;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem91Test {

    @Test
    void breakPalindrome() {
        Problem91 problem = new Problem91();

        assertEquals("aaccba", problem.breakPalindrome("abccba"));

        assertEquals("", problem.breakPalindrome("a"));

        assertEquals("aaaaccbaaa", problem.breakPalindrome("aaabccbaaa"));

        assertEquals("ab", problem.breakPalindrome("aa"));

        assertEquals("abb", problem.breakPalindrome("aba"));
    }
}