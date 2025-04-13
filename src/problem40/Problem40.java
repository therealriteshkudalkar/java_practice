package problem40;

public class Problem40 {
    public int maxSubArrayBruteForce(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        // TODO: Rectify the error with the min and max calculation
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum);
        }
        // Now find the maximum and the minimum in the prefix sum
        if (maxSum == minSum) {
            return maxSum;
        } else if (maxSum > 0 && minSum < 0) {
            return maxSum - minSum;
        } else if (maxSum > 0 && minSum > 0) {
            return maxSum;
        } else if (maxSum < 0) {
            return minSum - maxSum;
        } else {
            return maxSum;
        }
    }

    public int maxSubArrayKadane(int[] nums) {
        // Kadane's Algorithm
        if (nums.length == 0) {
            return 0;
        }

        // Calculate prefix sum
        int[] prefixSum = new int[nums.length];
        int sum = nums[0];
        prefixSum[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int maxSubArraySum = Integer.MIN_VALUE;
        int minPrefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            maxSubArraySum = Math.max(maxSubArraySum, prefixSum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }
        return maxSubArraySum;
    }

    public int maxSubArrayKadaneSimplified(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int localMaximum = 0;
        int globalMaximum = Integer.MIN_VALUE;
        for (int num: nums) {
            localMaximum = Math.max(num, num + localMaximum);
            globalMaximum = Math.max(globalMaximum, localMaximum);
        }
        return globalMaximum;
    }
}
