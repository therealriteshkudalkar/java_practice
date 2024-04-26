package problem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void isMatch() {
        Problem4 pb = new Problem4();
        String s = "ab";
        String p = "a.";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch1() {
        Problem4 pb = new Problem4();
        String s = "ab";
        String p = "a*";
        assertFalse(pb.isMatch(s, p));
    }

    @Test
    void isMatch2() {
        Problem4 pb = new Problem4();
        String s = "aa";
        String p = "a";
        assertFalse(pb.isMatch(s, p));
    }

    @Test
    void isMatch3() {
        Problem4 pb = new Problem4();
        String s = "bbbbb";
        String p = "b*";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch4() {
        Problem4 pb = new Problem4();
        String s = "abbbb";
        String p = ".b*";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch5() {
        Problem4 pb = new Problem4();
        String s = "acbbb";
        String p = ".c*b*";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch6() {
        Problem4 pb = new Problem4();
        String s = "mississipi";
        String p = "mis*s*i";
        assertFalse(pb.isMatch(s, p));
    }

    @Test
    void isMatch7() {
        Problem4 pb = new Problem4();
        String s = "aab";
        String p = "c*a*b";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch8() {
        Problem4 pb = new Problem4();
        String s = "mississippi";
        String p = "mis*is*ip*i";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch9() {
        Problem4 pb = new Problem4();
        String s = "ab";
        String p = "a*b";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch10() {
        Problem4 pb = new Problem4();
        String s = "ab";
        String p = ".*";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch11() {
        Problem4 pb = new Problem4();
        String s = "bbbba";
        String p = ".*a*a";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch12() {
        Problem4 pb = new Problem4();
        String s = "aaa";
        String p = "ab*a*c*a";
        assertTrue(pb.isMatch(s, p));
    }

    @Test
    void isMatch13() {
        Problem4 pb = new Problem4();
        String s = "aaaaaaaaaaaaab";
        String p = "a*a*a*a*a*a*a*a*a*c";
        assertFalse(pb.isMatch(s, p));
    }

    @Test
    void isMatch14() {
        Problem4 pb = new Problem4();
        String s = "ba";
        String p = ".*a*a";
        assertTrue(pb.isMatch(s, p));
    }
}