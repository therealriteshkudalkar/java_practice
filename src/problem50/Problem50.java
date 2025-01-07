package problem50;

import java.util.HashMap;


public class Problem50 {

    static class Triple {
        ListNode prev;
        ListNode next;
        boolean isInConnectedComponent;

        public Triple(ListNode prev, ListNode next, boolean isInConnectedComponent) {
            this.next = next;
            this.prev = prev;
            this.isInConnectedComponent = isInConnectedComponent;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, Triple> map = new HashMap<>();
        map.put(head.val, new Triple(null, head.next, false));
        while(head.next != null) {
            map.put(head.next.val, new Triple(head, head.next.next, false));
            head = head.next;
        }
        int count = 0;
        for (int num: nums) {
            if (map.containsKey(num)) {
                var pair = map.get(num);
                if (!pair.isInConnectedComponent) {
                    pair.isInConnectedComponent = true;
                    boolean partOfPreviousComponent = false;
                    boolean partOfNextComponent = false;
                    // Only one of the following conditions is true, then only form one connected component
                    // Check if previous node is part of some connected component
                    if (pair.prev != null && map.containsKey(pair.prev.val)) {
                        var prevTriple = map.get(pair.prev.val);
                        if (prevTriple.isInConnectedComponent) {
                            partOfPreviousComponent = true;
                        }
                    }
                    // Check if next node is part of some connected component
                    if (pair.next != null && map.containsKey(pair.next.val)) {
                        var nextTriple = map.get(pair.next.val);
                        if (nextTriple.isInConnectedComponent) {
                            partOfNextComponent = true;
                        }
                    }
                    // Check if the previous or the next is in a connected component and if it is
                    if (partOfPreviousComponent && partOfNextComponent) {
                        count = count - 1;
                    } else if (!partOfPreviousComponent && !partOfNextComponent) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }
}
