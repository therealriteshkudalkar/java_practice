package problem44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem44Test {

    @Test
    void rob() {
        Problem44 pb = new Problem44();

        assertEquals(4, pb.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, pb.rob(new int[]{2, 7, 9, 3, 1}));
    }
}