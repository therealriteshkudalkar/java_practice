package problem32;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem32 {
    public long maximumSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return k == 0 ? nums[0] : 0;
        }

        // Save the prefix sum in the HashMap
        record Pair(Integer index, Long prefixSum) {}
        HashMap<Long, List<Pair>> map = new HashMap<>();
        map.put((long) nums[0], new ArrayList<>(List.of(new Pair(0, 0L))));
        long prefixSum = 0L;
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            long num = nums[i + 1];
            if (map.containsKey(num)) {
                // Check the size of the list
                List<Pair> pairs = map.get(num);
                if (pairs.size() == 1) {
                    // The list size is 1, append the new prefixSum
                    Pair pair = pairs.get(0);
                    Pair newPair = new Pair(i + 1, prefixSum);
                    if (pair.prefixSum() > newPair.prefixSum()) {
                        pairs.add(0, newPair);
                    } else {
                        pairs.add(newPair);
                    }
                } else {
                    // If the list size is 2, check which of the Pair can be evicted
                    Pair firstPair = pairs.get(0);
                    Pair secondPair = pairs.get(1);
                    Pair newPair = new Pair(i + 1, prefixSum);
                    if (firstPair.prefixSum() > newPair.prefixSum()) {
                        pairs.set(0, newPair);
                    } else if (secondPair.prefixSum() < newPair.prefixSum()) {
                        pairs.set(1, newPair);
                    }
                }
                // map.get(num).add(new Pair(i + 1, prefixSum));
            } else {
                map.put(num, new ArrayList<>(List.of( new Pair(i + 1, prefixSum))));
            }
        }

        // Now loop through the array again, this time to find good subarray
        long maximumSum = Integer.MIN_VALUE;
        boolean didntFindGoodSubarray = true;
        for (int num : nums) {
            long key1 = num + k;
            List<Pair> satisfyingPairs = map.get((long) num);
            for (Pair satisfyingPair: satisfyingPairs) {
                if (map.containsKey(key1)) {
                    // The map contains a good subarray
                    didntFindGoodSubarray = false;
                    List<Pair> pairs = map.get(key1);
                    for (Pair pair: pairs) {
                        if (pair.index() > satisfyingPair.index()) {
                            maximumSum = Math.max(maximumSum, key1 + pair.prefixSum() - satisfyingPair.prefixSum());
                        } else {
                            maximumSum = Math.max(maximumSum, num + satisfyingPair.prefixSum() - pair.prefixSum());
                        }
                    }
                }
                long key2 = num - k;
                if (map.containsKey(key2)) {
                    // The map contains a good subarray
                    didntFindGoodSubarray = false;
                    List<Pair> pairs = map.get(key2);
                    for (Pair pair: pairs) {
                        if (pair.index() > satisfyingPair.index()) {
                            maximumSum = Math.max(maximumSum, key2 + pair.prefixSum() - satisfyingPair.prefixSum());
                        } else {
                            maximumSum = Math.max(maximumSum, num + satisfyingPair.prefixSum() - pair.prefixSum());
                        }
                    }
                }
            }
        }
        return didntFindGoodSubarray? 0 : maximumSum;
    }

    public long maximumSubarraySumNaive(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return k == 0 ? nums[0] : 0;
        }
        // if k == 0 then find the largest element
        long maximumSum = Integer.MIN_VALUE;
        boolean didntFindGoodSubarray = true;
        for (int i = 0; i < nums.length; i++) {
            long currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                // Check if it's a good subarray
                if (Math.abs(nums[i] - nums[j]) == k) {
                    didntFindGoodSubarray = false;
                    // Yes, it's a good array
                    // Find its sum and check if that sum is greater than maximumSum
                    maximumSum = Math.max(maximumSum, currentSum);
                }
            }
        }

        return didntFindGoodSubarray ? 0 : maximumSum;
    }
}
