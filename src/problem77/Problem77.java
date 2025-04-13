package problem77;

public class Problem77 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode();
        ListNode temp = resultList;
        while(true) {
            if (list1 != null && list2 != null) {
                // Compare the first items from the list
                if (list1.val < list2.val) {
                    // Add item from list1 to the resultList
                    temp.next = list1;
                    list1 = list1.next;
                    temp = temp.next;
                } else {
                    // Add item from list2 to the resultList
                    temp.next = list2;
                    list2 = list2.next;
                    temp = temp.next;
                }
                // keep on adding items from list 2
            } else if (list1 == null && list2 != null) {
                // Since list 2 is not null keep adding the items from the list2
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            } else if (list1 != null) {
                // Since list 1 is not null keep adding the items from the list1
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = null;
                break;
            }
        }
        return resultList.next;
    }
}
