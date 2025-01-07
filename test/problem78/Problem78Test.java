package problem78;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem78Test {

    @Test
    void reverseList() {
        Problem78 problem = new Problem78();

        ListNode testList1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expectedList1 = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        assertEquals(expectedList1.toString(), problem.reverseList(testList1).toString());

        ListNode testList2 = new ListNode(1, new ListNode(2));
        ListNode expectedList2 = new ListNode(2, new ListNode(1));
        assertEquals(expectedList2.toString(), problem.reverseList(testList2).toString());
    }
}