package problem75;

import java.util.LinkedList;
import java.util.List;

public class Problem75 {
    private int maxCoinsRec(LinkedList<Integer> nums) {
        if (nums.isEmpty()) {
            return 1;
        }
        for (int i = 0; i < nums.size(); i++) {
            // We have two options:
            // 1. Burst the current balloon
            int choiceA = i == 0 ? (nums.get(i) * nums.get(i + 1)) : (nums.get(i - 1) * nums.get(i) * nums.get(i + 1)) + maxCoinsRec(nums);
            // 2. Skip bursting the current balloon

        }
        return 0;
    }

    public int maxCoins(int[] nums) {
        return maxCoinsRec(new LinkedList<>());
    }
}
