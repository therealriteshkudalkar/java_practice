package problem71;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem71 {
    public static class MedianFinder {
        private final PriorityQueue<Integer> minHeap;
        private final PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            // Going to check the size of minHeap and maxHeap and put it into the heap accordingly

            // Size of minHeap here is always greater than 0
            // If the heaps are already balanced so directly add num to minHeap
            // If heaps are not balanced so try removing an element from minHeap and add to maxHeap

            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            return this.minHeap.size() == this.maxHeap.size() ?
                    (double) (minHeap.peek() + maxHeap.peek()) / 2 : maxHeap.peek();
        }
    }
}
