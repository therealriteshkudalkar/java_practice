package problem103;

import java.util.PriorityQueue;

public class Problem103 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num: nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else {
                if (minHeap.peek() != null) {
                    if (num >= minHeap.peek()) {
                        minHeap.poll();
                        minHeap.add(num);
                    }
                }
            }
        }
        return minHeap.peek() != null ? minHeap.peek() : -1;
    }
}
