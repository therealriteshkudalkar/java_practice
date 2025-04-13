package problem34;

import java.util.Arrays;
import java.util.HashMap;

public class Problem34 {

    public int lengthOfLISTabulated(int[] nums) {
        int[] subsequenceCount = new int[nums.length];
        Arrays.fill(subsequenceCount, 1);
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                // New nums[i] can be added to the existing subsequence only if nums[i] > nums[j]
                if (nums[i] > nums[j]) {
                    subsequenceCount[i] = Math.max(subsequenceCount[i], 1 + subsequenceCount[j]);
                    maxCount = Math.max(maxCount, subsequenceCount[i]);
                }
            }
        }
        return maxCount;
    }

    public int lengthOfLISMemoized(HashMap<String, Integer> memo, int[] nums, int index, int lastNumber) {
        String key = String.format("%d,%d", index, lastNumber);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == nums.length) {
            return 0;
        }

        // Skip the current number
        int lengthSkip = lengthOfLISMemoized(memo, nums, index + 1, lastNumber);
        // Take the current number
        int lengthTake = lastNumber < nums[index] ? 1 + lengthOfLISMemoized(memo, nums, index + 1, nums[index]) : lengthSkip;

        int maxLength = Math.max(lengthSkip, lengthTake);
        memo.put(key, maxLength);
        return maxLength;
    }

    public int lengthOfLISRec(int[] nums, int index, int lastNumber) {
        if (index == nums.length) {
            return 0;
        }

        // Skip the current number
        int lengthSkip = lengthOfLISRec(nums, index + 1, lastNumber);
        // Take the current number: Two cases the number is greater than lastNumber in which case take
        int lengthTake = lastNumber < nums[index] ? 1 + lengthOfLISRec(nums, index + 1, nums[index]) : lengthSkip;

        return Math.max(lengthSkip, lengthTake);
    }

    public int lengthOfLIS(int[] nums) {
        // return lengthOfLISRec(nums, 0, Integer.MIN_VALUE);
        // return lengthOfLISMemoized(new HashMap<>(), nums, 0, Integer.MIN_VALUE);
        return lengthOfLISTabulated(nums);
    }
}
