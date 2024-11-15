package problem40;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem40Test {

    @Test
    void maxSubArray() {
        Problem40 pb = new Problem40();

        assertEquals(6, pb.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, pb.maxSubArray(new int[]{1}));
        assertEquals(23, pb.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        assertEquals(-1, pb.maxSubArray(new int[]{-1}));
        assertEquals(-1, pb.maxSubArray(new int[]{-2, -1}));
        assertEquals(1, pb.maxSubArray(new int[]{-2, 1}));
    }

    @Test
    void maxSubArrayKadane() {
        Problem40 pb = new Problem40();

        assertEquals(6, pb.maxSubArrayKadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, pb.maxSubArrayKadane(new int[]{1}));
        assertEquals(23, pb.maxSubArrayKadane(new int[]{5, 4, -1, 7, 8}));
        assertEquals(-1, pb.maxSubArrayKadane(new int[]{-1}));
        assertEquals(-1, pb.maxSubArrayKadane(new int[]{-2, -1}));
        assertEquals(1, pb.maxSubArrayKadane(new int[]{-2, 1}));
    }
}