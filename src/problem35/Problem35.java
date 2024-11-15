package problem35;

public class Problem35 {
    public int lengthOfLISOptimized(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        // Created a 2D Array of size nums.length and k
        // What would dp[i][j] mean ... here i represents the value of k and i represents the LIS count,
        // // for which the difference between two consecutive numbers is at most i + 1
        int[][] subsequenceCount = new int[k][nums.length];
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {

            }
        }
        return best;

    }

    public int lengthOfLIS(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] subsequenceCount = new int[nums.length];
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            subsequenceCount[i] = 1;
            for (int j = 0; j < i; j++) {
                // Break out of the inner loop
                if (nums[j] < nums[i] && Math.abs(nums[i] - nums[j]) <= k) {
                    subsequenceCount[i] = Math.max(subsequenceCount[i], 1 + subsequenceCount[j]);
                }
            }
            best = Math.max(best, subsequenceCount[i]);
        }
        return best;
    }
}
