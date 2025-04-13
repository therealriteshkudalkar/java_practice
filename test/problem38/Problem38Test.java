package problem38;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem38Test {

    @Test
    void threeSum() {
        Problem38 pb = new Problem38();

        // Test 1
        List<List<Integer>> list1 = new ArrayList<>(List.of(
                new ArrayList<>(List.of(-1, -1, 2)),
                new ArrayList<>(List.of(-1, 0, 1))
        ));
        assertEquals(list1, pb.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

        // Test 2
        List<List<Integer>> list2 = new ArrayList<>();
        assertEquals(list2, pb.threeSum(new int[]{0, 1, 1}));

        // Test 3
        List<List<Integer>> list3 = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 0, 0))
        ));
        assertEquals(list3, pb.threeSum(new int[]{0, 0, 0}));
    }
}