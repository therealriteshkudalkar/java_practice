package problem83;

import java.util.HashMap;

public class Problem83 {

    private long maxAlternatingSumTabulated(int[] nums) {
        long[][] memo = new long[nums.length + 1][2];
        // 0 - False; 1 - True
        for (int i = 1; i <= nums.length; i++) {
            // Compare both skip and take
            memo[i][0] = Math.max(memo[i - 1][0], nums[i - 1] + memo[i - 1][1]);
            // Compare both skip and take
            memo[i][1] = Math.max(memo[i - 1][1], -nums[i - 1] + memo[i - 1][0]);
        }
        return Math.max(memo[nums.length][0], memo[nums.length][1]);
    }

    private long maxAlternatingSumMemoized(HashMap<String, Long> memo, int[] nums, int index, boolean isEven) {
        String key = String.format("%d,%b", index, isEven);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (index == nums.length) {
            return 0;
        }
        long resultTake = ((isEven ? 1 : - 1) * nums[index] + maxAlternatingSumMemoized(memo, nums, index + 1, !isEven));
        long resultSkip = maxAlternatingSumMemoized(memo, nums, index + 1, isEven);
        long result = Math.max(resultTake, resultSkip);
        memo.put(key, result);
        return result;
    }

    private long maxAlternatingSumRec(int[] nums, int index, boolean isEven) {
        if (index == nums.length) {
            return 0;
        }
        // Take the current index value or not take the current index value
        long resultTake = ((isEven ? 1 : -1 ) * nums[index]) + maxAlternatingSumRec(nums, index + 1, !isEven);
        long resultSkip = maxAlternatingSumRec(nums, index + 1, isEven);
        return Math.max(resultTake, resultSkip);
    }

    public long maxAlternatingSum(int[] nums) {
        // return maxAlternatingSumRec(nums, 0, true);
        // return maxAlternatingSumMemoized(new HashMap<>(), nums, 0, true);
        return maxAlternatingSumTabulated(nums);
    }
}
