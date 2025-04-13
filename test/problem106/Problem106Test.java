package problem106;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem106Test {

    @Test
    void mergeKLists() {
        Problem106 problem = new Problem106();

        // Test 1
        ListNode[] list1 = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
        };
        ListNode sortedList1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));
        assertEquals(sortedList1.toString(), problem.mergeKLists(list1).toString());

        // Test 2
        ListNode[] list2 = new ListNode[]{};
        assertNull(problem.mergeKLists(list2));

        // Test 3
        ListNode[] list3 = new ListNode[]{null};
        assertNull(problem.mergeKLists(list3));
    }
}