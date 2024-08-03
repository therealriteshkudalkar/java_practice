package problem14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem14Test {
    @Test
    void testRandomizedSet() {
        // Test 1
        Problem14.RandomizedSet set = new Problem14.RandomizedSet();
        assertTrue(set.insert(1));
        assertFalse(set.remove(2));
        assertTrue(set.insert(2));
        // assertEquals(2, set.getRandom());
        assertTrue(set.remove(1));
        assertFalse(set.insert(2));
    }
}