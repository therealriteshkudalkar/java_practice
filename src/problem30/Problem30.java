package problem30;

import java.util.HashSet;
import java.util.Set;

public class Problem30 {
    public ListNode detectCycle(ListNode head) {
        return null;
    }

    public ListNode detectCycleNaive(ListNode head) {
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
