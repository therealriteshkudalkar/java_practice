package problem52;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Problem52 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Loop through first k numbers and form a treemap of number and count
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int totalWindows = nums.length - k + 1;
        int[] maxInWindow = new int[totalWindows];
        for (int i = 0; i < totalWindows; i++) {
            // Fetch the max item for the list
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            maxInWindow[i] = entry.getKey();
            map.put(entry.getKey(), entry.getValue());

            // Remove the last element
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) == 1) {
                    // Remove the entry from the map
                    map.remove(nums[i]);
                } else {
                    // Decrement the count from the map
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
            } else {
                // Error
                return maxInWindow;
            }

            // Add new element
            if (i != totalWindows - 1) {
                if (map.containsKey(nums[i + k])) {
                    map.put(nums[i + k], 1 + map.get(nums[i + k]));
                } else {
                    map.put(nums[i + k], 1);
                }
            }
        }
        return maxInWindow;
    }
}
