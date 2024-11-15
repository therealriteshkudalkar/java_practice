package problem30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem30Test {

    @Test
    void detectCycleNaive() {
        Problem30 pb = new Problem30();

        ListNode listWithoutCycle = new ListNode(5, new ListNode(2, new ListNode(3)));
        assertNull(pb.detectCycleNaive(listWithoutCycle));

        ListNode listWithoutCycle1 = new ListNode(5);
        assertNull(pb.detectCycleNaive(listWithoutCycle1));

        ListNode listA = new ListNode(2);
        ListNode listWithCycle1 = new ListNode(1, listA);
        listA.next = listWithCycle1;
        assertEquals(listWithCycle1, pb.detectCycleNaive(listWithCycle1));

        ListNode listC = new ListNode(-4);
        ListNode listB = new ListNode(2, new ListNode(0, listC));
        ListNode listWithCycle2 = new ListNode(3, listB);
        listC.next = listB;
        assertEquals(listB, pb.detectCycleNaive(listWithCycle2));

        ListNode listWithCycle3 = new ListNode(2);
        listWithCycle3.next = listWithCycle3;
        assertEquals(listWithCycle3, pb.detectCycleNaive(listWithCycle3));
    }
}