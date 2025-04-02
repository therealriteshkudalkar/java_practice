package problem105;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem105Test {
    @Test
    void kthLargest() {
        Problem105.KthLargest test1 = new Problem105.KthLargest(3, new int[]{4, 5, 8, 2});
        assertEquals(4, test1.add(3));
        assertEquals(5, test1.add(5));
        assertEquals(5, test1.add(10));
        assertEquals(8, test1.add(9));
        assertEquals(8, test1.add(4));

        Problem105.KthLargest test2 = new Problem105.KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        assertEquals(7, test2.add(2));
        assertEquals(7, test2.add(10));
        assertEquals(7, test2.add(9));
        assertEquals(8, test2.add(9));
    }
}