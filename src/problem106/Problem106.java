package problem106;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem106 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list: lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = null;
        ListNode temp = null;
        while(!queue.isEmpty()) {
            ListNode currentList = queue.poll();

            // From the current list extract the first item
            if (temp == null) {
                head = currentList;
                temp = currentList;
            } else {
                temp.next = currentList;
                temp = temp.next;
            }
            currentList = currentList.next;
            if (currentList != null) {
                queue.add(currentList);
            }
            if (temp != null) {
                temp.next = null;
            }
        }
        return head;
    }
}
