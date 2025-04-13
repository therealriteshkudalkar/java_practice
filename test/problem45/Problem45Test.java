package problem45;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem45Test {

    @Test
    void wordBreakBruteForce() {
        Problem45 pb = new Problem45();

        assertTrue(pb.wordBreakBruteForce("leetcode", List.of("leet", "code")));

        assertTrue(pb.wordBreakBruteForce("applepenapple", List.of("apple", "pen")));

        assertFalse(pb.wordBreakBruteForce("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

        assertTrue(pb.wordBreakBruteForce("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    @Test
    void wordBreak() {
        Problem45 pb = new Problem45();

        assertTrue(pb.wordBreak("leetcode", List.of("leet", "code")));

        assertTrue(pb.wordBreak("applepenapple", List.of("apple", "pen")));

        assertFalse(pb.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

        assertFalse(pb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

    }
}