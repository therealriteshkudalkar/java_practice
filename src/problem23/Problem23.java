package problem23;

import java.util.ArrayList;
import java.util.List;

public class Problem23 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            list.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }
        return list;
    }

    public List<List<Integer>> fourSumOptimized(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        return list;
    }
}
