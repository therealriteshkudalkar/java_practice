package problem78;

public class Problem78 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Traverse the LinkedList
        //null <- 1 (h), 2 (t), 3 (t), null (r)
        ListNode remainingList = head.next;
        ListNode temp = head;
        ListNode headOfReverseList = null;

        while(remainingList != null) {
            temp.next = headOfReverseList;
            headOfReverseList = temp;
            temp = remainingList;
            remainingList = remainingList.next;
        }
        temp.next = headOfReverseList;
        headOfReverseList = temp;

        // Have a pointer to head's next and another pointer on head itself
        return headOfReverseList;
    }
}
