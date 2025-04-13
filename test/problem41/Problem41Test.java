package problem41;

import org.junit.jupiter.api.Test;
import problem7.Problem7;

import static org.junit.jupiter.api.Assertions.*;

class Problem41Test {

    @Test
    void lengthOfLongestSubstring() {
        Problem41 pb = new Problem41();

        assertEquals(3, pb.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, pb.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, pb.lengthOfLongestSubstring("pwwkew"));
    }
}