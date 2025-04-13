package problem105;

import java.util.PriorityQueue;

public class Problem105 {
    static class KthLargest {
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private final int k;

        private void addNewNumberToHeap(int num) {
            if (this.minHeap.size() < k) {
                this.minHeap.add(num);
            } else {
                if (this.minHeap.peek() != null) {
                    if (this.minHeap.peek() < num) {
                        this.minHeap.poll();
                        this.minHeap.add(num);
                    }
                }
            }
        }

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int num: nums) {
                this.addNewNumberToHeap(num);
            }
        }

        public int add(int val) {
            this.addNewNumberToHeap(val);
            return minHeap.peek() != null ? minHeap.peek() : -1;
        }
    }
}
