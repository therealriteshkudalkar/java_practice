package problem73;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem73 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int pile: piles) {
            queue.add(pile);
        }
        for(int i = 0; i < k; i++) {
            // Remove the largest
            int num = queue.poll();
            queue.add(Math.ceilDiv(num, 2));
        }
        int sum = 0;
        for (int element: queue) {
            sum += element;
        }
        return sum;
    }
}
