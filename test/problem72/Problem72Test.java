package problem72;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem72Test {

    @Test
    void frequencySort() {
        Problem72 problem = new Problem72();

        assertEquals("eert", problem.frequencySort("tree"));
        assertEquals("aaaccc", problem.frequencySort("aaaccc"));
        assertEquals("bbAa", problem.frequencySort("Aabb"));
    }

    @Test
    void frequencySortOptimized() {
        Problem72 problem = new Problem72();

        assertEquals("eert", problem.frequencySortOptimized("tree"));
        assertEquals("aaaccc", problem.frequencySortOptimized("aaaccc"));
        assertEquals("bbAa", problem.frequencySortOptimized("Aabb"));
        assertEquals("eeeeaaarrd", problem.frequencySortOptimized("raaeaedere"));
    }
}