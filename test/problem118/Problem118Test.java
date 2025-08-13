package problem118;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem118Test {

    @Test
    void hasAllCodes() {
        Problem118 problem118 = new Problem118();

        // Test 1
        assertTrue(problem118.hasAllCodes("00110110", 2));

        // Test 2
        assertTrue(problem118.hasAllCodes("0110", 1));

        // Test 3
        assertFalse(problem118.hasAllCodes("0110", 2));

        // Test 4
        assertTrue(problem118.hasAllCodes("00110", 2));

    }
}