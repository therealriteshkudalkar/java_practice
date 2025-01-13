package problem87;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem87Test {

    @Test
    void longestStrChain() {
        Problem87 problem = new Problem87();

        assertEquals(4, problem.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));

        assertEquals(5, problem.longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));

        assertEquals(1, problem.longestStrChain(new String[]{"abcd", "dbqca"}));
    }
}