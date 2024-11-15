package problem38;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem38 {
    private void twoSum(int[] nums, int i, List<List<Integer>> sumCandidates) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                sumCandidates.add(List.of(nums[i], nums[left], nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the nums arrays in place
        Arrays.sort(nums);
        List<List<Integer>> threeSumValues = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, threeSumValues);
            }
        }
        return threeSumValues;
    }
}
