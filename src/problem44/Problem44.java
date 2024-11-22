package problem44;

public class Problem44 {
    public int robBruteForce(int[] nums) {
        return 0;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxMoneyCollected = new int[nums.length];
        maxMoneyCollected[0] = nums[0];
        maxMoneyCollected[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            maxMoneyCollected[i] = Math.max(nums[i] + maxMoneyCollected[i - 2],maxMoneyCollected[i - 1]);
        }
        return maxMoneyCollected[nums.length - 1];
    }
}
