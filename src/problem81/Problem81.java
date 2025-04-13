package problem81;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem81 {
    private void combinationSumRec(Set<List<Integer>> result, List<Integer> currentResult, int sum, int index, int[] candidates, int target) {
        // Combinations with repetitions
        if (index == candidates.length) {
            if (sum == target) {
                result.add(List.copyOf(currentResult));
            }
            return;
        }
        if (sum > target) {
            return;
        }
        // Add the current index to the sum and can be done multiple time
        currentResult.add(candidates[index]);
        combinationSumRec(result, currentResult, sum + candidates[index], index, candidates, target);
        combinationSumRec(result, currentResult, sum + candidates[index], index + 1, candidates, target);
        currentResult.removeLast();
        combinationSumRec(result, currentResult, sum, index + 1, candidates, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        combinationSumRec(result, new ArrayList<>(), 0, 0, candidates, target);
        return result.stream().toList();
    }
}
