package problem42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem42Test {

    @Test
    void minWindow() {
        Problem42 pb = new Problem42();

        assertEquals("BANC", pb.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", pb.minWindow("a", "a"));
        assertEquals("", pb.minWindow("a", "aa"));
        assertEquals("hel", pb.minWindow("hello", "hel"));
    }
}