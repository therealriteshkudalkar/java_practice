package problem37;

import java.util.HashMap;

public class Problem37 {
    public int findMaxLengthOptimized(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int relativeCount = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            relativeCount += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(relativeCount)) {
                maxLength = Math.max(maxLength, i - map.get(relativeCount));
            } else {
                map.put(relativeCount, i);
            }
        }
        return maxLength;
    }

    public int findMaxLength(int[] nums) {
        // Find the prefix sum i.e. count of '0's and '1's seen
        int[][] prefixSum = new int[nums.length][2];
        int prefixSumForZero = 0;
        int prefixSumForOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSumForZero += 1;
            } else {
                prefixSumForOne += 1;
            }
            prefixSum[i][0] = prefixSumForZero;
            prefixSum[i][1] = prefixSumForOne;
        }

        // Find the index with max '0's
        // Find the window, where the difference between prefixSumForZero of both indices is equal
        // // to the difference between the prefixSumForOne of both indices
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int differenceOfPrefixSumForZero = prefixSum[j][0] - prefixSum[i][0] + (nums[i] == 0 ? 1 : 0);
                int differenceOfPrefixSumForOne = prefixSum[j][1] - prefixSum[i][1] + (nums[i] == 1 ? 1 : 0);

                if (differenceOfPrefixSumForOne == differenceOfPrefixSumForZero) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}
