package problem108;

import java.util.*;

public class Problem108 {
    public int[] topKFrequent(int[] nums, int k) {
        record Pair(int frequency, int item) {}

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::frequency).reversed());
        for (Map.Entry<Integer, Integer> frequencyItem: frequencyMap.entrySet()) {
            queue.add(new Pair(frequencyItem.getValue(), frequencyItem.getKey()));
        }

        int[] topKElement = new int[k];
        for (int i = 0; i < k; i++) {
            Pair pair = queue.poll();
            topKElement[i] = pair.item;
        }
        return topKElement;
    }
}
