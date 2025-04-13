package problem7;

public class Problem7 {
    public double findMaxAverage(int[] nums, int k) {
        // Find sum of first window of size k
        int largestSum = 0;
        for (int i = 0; i < k; i++) {
            largestSum += nums[i];
        }
        // Shift the Window of size k by 1, also add and remove elements
        int currentSum = largestSum;
        for (int i = k; i < nums.length; i++) {
            // take num at i - k and remove it from the currentSum and add num at i
            currentSum = currentSum -  nums[i - k] + nums[i];
            largestSum = Math.max(largestSum, currentSum);
        }
        return (double) largestSum / k;
    }
}
