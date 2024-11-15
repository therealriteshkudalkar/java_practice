package problem36;

public class Problem36 {
    static class NumArray {
        private int[] nums;
        private int[] prefixSum;
        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefixSum = new int[nums.length];

            // Calculate the prefix sum
            int currentIndexPrefixSum = 0;
            for (int i = 0; i < nums.length; i++) {
                currentIndexPrefixSum += nums[i];
                prefixSum[i] = currentIndexPrefixSum;
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right] - prefixSum[left] + nums[left];
        }
    }

}
