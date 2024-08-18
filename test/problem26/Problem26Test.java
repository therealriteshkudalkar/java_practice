package problem26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem26Test {

    @Test
    void convert() {
        Problem26 pb = new Problem26();

        // Test 1
        assertEquals("PINALSIGYAHRPI", pb.convert("PAYPALISHIRING", 4));

        // Test 2
        assertEquals("PAHNAPLSIIGYIR", pb.convert("PAYPALISHIRING", 3));
    }
}