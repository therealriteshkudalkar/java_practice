package problem50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem50Test {

    @Test
    void numComponents() {
        Problem50 problem = new Problem50();

        ListNode head1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        assertEquals(2, problem.numComponents(head1, new int[]{0, 1, 3}));

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        assertEquals(2, problem.numComponents(head2, new int[]{0, 3, 1, 4}));
    }
}