package problem77;

import org.junit.jupiter.api.Test;
import problem72.Problem72;

import static org.junit.jupiter.api.Assertions.*;

class Problem77Test {

    @Test
    void mergeTwoLists() {
        Problem77 problem = new Problem77();

        ListNode inputListA1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode inputListA2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode expectedList = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        assertEquals(expectedList.toString(), problem.mergeTwoLists(inputListA1, inputListA2).toString());
    }
}