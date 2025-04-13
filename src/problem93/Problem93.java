package problem93;

public class Problem93 {
    public long maxBalancedSubsequenceSum(int[] nums) {
        // First column represents the count and second column represents the sum
        long[] memo = new long[nums.length];
        long maxSumSoFar = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            memo[i] = nums[i];
            maxSumSoFar = Math.max(maxSumSoFar, memo[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - nums[j] >= i - j) {
                    // Add the nums[i] to the subsequence at nums[j]
                    memo[i] = Math.max(memo[i], nums[i] + memo[j]);
                    maxSumSoFar = Math.max(maxSumSoFar, memo[i]);
                }
            }
        }
        return maxSumSoFar;
    }
}
