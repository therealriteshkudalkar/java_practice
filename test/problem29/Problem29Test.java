package problem29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem29Test {

    @Test
    void hasCycle() {
        Problem29 pb = new Problem29();

        ListNode listWithoutCycle = new ListNode(1, new ListNode(2));
        assertFalse(pb.hasCycle(listWithoutCycle));

        ListNode listWithoutCycle1 = new ListNode(2);
        assertFalse(pb.hasCycle(listWithoutCycle1));

        ListNode listWithoutCycle2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        assertFalse(pb.hasCycle(listWithoutCycle2));

        ListNode listA = new ListNode(2);
        ListNode listWithCycle1 = new ListNode(1, listA);
        listA.next = listWithCycle1;
        assertTrue(pb.hasCycle(listWithCycle1));

        ListNode listC = new ListNode(-4);
        ListNode listB = new ListNode(2, new ListNode(0, listC));
        ListNode listWithCycle2 = new ListNode(3, listB);
        listC.next = listB;
        assertTrue(pb.hasCycle(listWithCycle2));

        ListNode listWithCycle3 = new ListNode(2);
        listWithCycle3.next = listWithCycle3;
        assertTrue(pb.hasCycle(listWithCycle3));


    }
}