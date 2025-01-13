package problem35;

import java.util.Arrays;

public class Problem35 {
    public int lengthOfLISTabulated(int[] nums, int k) {
        int[] subsequenceLength = new int[nums.length];
        Arrays.fill(subsequenceLength, 1);
        int maxLength = 1;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] - nums[j] <= k) {
                    subsequenceLength[i] = Math.max(subsequenceLength[i], 1 + subsequenceLength[j]);
                    maxLength = Math.max(maxLength, subsequenceLength[i]);
                }
            }
        }
        return maxLength;
    }

    public int lengthOfLIS(int[] nums, int k) {
        return lengthOfLISTabulated(nums, k);
    }
}
