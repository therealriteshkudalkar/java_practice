package problem8;

public class Problem8 {
    public int subarraySum(int[] nums, int k) {
        // Find the smallest number in the array
        int smallest = nums[0];
        for (int num: nums) {
            if (smallest > num) {
                smallest = num;
            }
        }
        int count = 0;
        int offset = (smallest < 0 ? -1 * smallest: smallest) + 1;
        System.out.println(offset);
        int upperWindowIndex, lowerWindowIndex = 0;
        int currentSum = 0;
        for (upperWindowIndex = 0; upperWindowIndex < nums.length; upperWindowIndex++) {
            int requiredK = k + offset * (upperWindowIndex - lowerWindowIndex + 1);
            currentSum += nums[upperWindowIndex] + offset;
            if (currentSum == requiredK) {
                count += 1;
            } else if (currentSum > requiredK) {
                while (currentSum > requiredK) {
                    currentSum -= nums[lowerWindowIndex] + offset;
                    lowerWindowIndex += 1;
                    requiredK = k + offset * (upperWindowIndex - lowerWindowIndex + 1);
                    if (currentSum == requiredK) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
}
