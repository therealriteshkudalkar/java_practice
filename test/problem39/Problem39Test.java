package problem39;

import org.junit.jupiter.api.Test;
import problem37.Problem37;

import static org.junit.jupiter.api.Assertions.*;

class Problem39Test {

    @Test
    void threeSumClosest() {
        Problem39 pb = new Problem39();

        assertEquals(2, pb.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        assertEquals(0, pb.threeSumClosest(new int[]{0, 0, 0}, 1));
        assertEquals(2, pb.threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}