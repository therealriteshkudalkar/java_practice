package problem20;

public class Problem20 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int previousElement = nums[0];
        int duplicateCount = 0;
        for (int i = 1; i < nums.length; i++) {
            int currentElement = nums[i];
            if (previousElement == currentElement) {
                // duplicate element found
                duplicateCount++;
            }
            // shift by number of duplicates found upto now
            for (int j = i; j > i - duplicateCount; j--) {
                nums[j - 1] = nums[j];
            }
            previousElement = currentElement;
        }
        return nums.length - duplicateCount;
    }

    /*
    ** Only need to keep a tab on the index of the latest number
    */
    public int removeDuplicatesOptimized(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            k++;
            nums[k] = nums[i];
        }
        return k + 1;
    }
}
