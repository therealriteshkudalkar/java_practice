package problem5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void summaryRanges() {
        Problem5 pb = new Problem5();
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> list = new ArrayList<>(Arrays.asList("0->2", "4->5", "7"));
        assertEquals(list, pb.summaryRanges(nums));
    }

    @Test
    void summaryRanges1() {
        Problem5 pb = new Problem5();
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<String> list = new ArrayList<>(Arrays.asList("0", "2->4", "6", "8->9"));
        assertEquals(list, pb.summaryRanges(nums));
    }

    @Test
    void summaryRanges2() {
        Problem5 pb = new Problem5();
        int[] nums = new int[]{0, 1};
        List<String> list = new ArrayList<>(List.of("0->1"));
        assertEquals(list, pb.summaryRanges(nums));
    }

    @Test
    void summaryRanges3() {
        Problem5 pb = new Problem5();
        int[] nums = new int[]{-1};
        List<String> list = new ArrayList<>(List.of("-1"));
        assertEquals(list, pb.summaryRanges(nums));
    }
}