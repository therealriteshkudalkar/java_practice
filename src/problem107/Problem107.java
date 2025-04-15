package problem107;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem107 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            queue.add(stone);
        }

        while(!queue.isEmpty() && queue.size() > 1) {
            int stoneY = queue.poll();
            int stoneX = queue.poll();
            if (stoneX != stoneY) {
                int remainingStone = stoneY - stoneX;
                queue.add(remainingStone);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }
}
