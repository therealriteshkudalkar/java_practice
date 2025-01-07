package problem76;

import java.util.ArrayList;
import java.util.List;

public class Problem76 {
    private void subsetsRec(List<List<Integer>> result, List<Integer> currentList, int[] nums, int index) {
        if (index == nums.length) {
            result.add(List.copyOf(currentList));
            return;
        }

        // Add the current index to subset or don't add the current index to the subset i.e. skip index
        currentList.addLast(nums[index]);
        subsetsRec(result, currentList, nums, index + 1);
        currentList.removeLast();
        subsetsRec(result, currentList, nums, index + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsRec(result, new ArrayList<>(), nums, 0);
        return result;
    }
}
