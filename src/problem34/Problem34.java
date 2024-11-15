package problem34;

public class Problem34 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int[] subsequenceCount = new int[nums.length];
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            subsequenceCount[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    subsequenceCount[i] = Math.max(subsequenceCount[i], 1 + subsequenceCount[j]);
                }
            }
            best = Math.max(best, subsequenceCount[i]);
        }
        return best;
    }
}
