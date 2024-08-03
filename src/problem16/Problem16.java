package problem16;

public class Problem16 {

    /*
    ** Naive approach would be to get all the permutations in an array and get the index of that combination
    ** which is one more than the one that matches nums.
    ** Time: O(n!)
    ** Space: O(n)
    *
    ** A smarter approach is to look at how to tree structure changes with each permutation.
    ** You can notice that the first pair of elements to be in ascending order form the right, is the one where
    ** the new permutation branches from.
    ** Time: O(n)
    ** Space: O(1)
    */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        // 'i' now has the index where nums[i] >= nums[i - 1]
        // find the number which is just greater than nums[i - 1] to the right of i - 1
        if (i > 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        // Reverse the array from i to nums.length - 1
        int leftIndex = i;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            swap(nums, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
