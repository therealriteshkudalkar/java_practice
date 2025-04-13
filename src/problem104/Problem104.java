package problem104;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem104 {
    record Pair(double distance, int[] point) {}

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(Pair::distance).reversed());
        for(int[] point: points) {
            double currentPointDistance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            if (maxHeap.size() < k) {
                maxHeap.add(new Pair(currentPointDistance, point));
            } else {
                if (maxHeap.peek() != null) {
                    if (currentPointDistance < maxHeap.peek().distance) {
                        maxHeap.poll();
                        maxHeap.add(new Pair(currentPointDistance, point));
                    }
                }
            }
        }

        // Finally return the points
        int[][] returnVector = new int[k][2];
        int index = 0;
        for(Pair pair: maxHeap) {
            returnVector[index++] = pair.point;
        }
        return returnVector;
    }
}
