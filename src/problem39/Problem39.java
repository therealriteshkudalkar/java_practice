package problem39;

public class Problem39 {
    public int threeSumClosesOptimized(int[] nums, int target) {
        return 0;
    }

    public int threeSumClosest(int[] nums, int target) {
        int closestTargetSum = Integer.MAX_VALUE;
        int actualTargetSum = Integer.MAX_VALUE;

        // Closest Target Sum cloud also be negative
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int currentSum = nums[i] + nums[j] + nums[k];
                    int proximity = Math.abs(currentSum - target);
                    if (proximity < closestTargetSum) {
                        closestTargetSum = proximity;
                        actualTargetSum = currentSum;
                    }
                }
            }
        }
        return actualTargetSum;
    }
}
