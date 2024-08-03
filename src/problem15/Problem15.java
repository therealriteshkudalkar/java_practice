package problem15;

import java.util.HashMap;

public class Problem15 {
    /*
    ** Time: O(n^3)
    ** Space: O(n)
     */
    public int subarraySumNaive(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
    ** Time: O(n^2)
    ** Space: O(1)
    */
    public int subarraySumOptimized(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int previousSubArraySum = 0;
            for (int end = start; end < nums.length; end++) {
                int currentSubArraySum = previousSubArraySum + nums[end];
                if (currentSubArraySum == k) {
                    count++;
                }
                previousSubArraySum = currentSubArraySum;
            }
        }
        return count;
    }

    /*
    ** Time: O(n)
    ** Space: O(n)
    ** Intuition: If the cumulative sum (represented by sum[i] for sum up to ith index) up to two indices is the same,
    ** the sum of the elements lying in between those indices is zero. Extending the same thought further,
    ** if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i]−sum[j]=k,
    ** the sum of elements lying between indices i and j is k.
    **/
    public int subarraySumHighlyOptimized(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumOccurrencesMap = new HashMap<>();
        sumOccurrencesMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (sumOccurrencesMap.containsKey(sum - k)) {
                count += sumOccurrencesMap.get(sum - k);
            }
            sumOccurrencesMap.put(sum, sumOccurrencesMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
