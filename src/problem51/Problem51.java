package problem51;

public class Problem51 {
    public int search(int[] nums, int target) {
        int lb = 0, ub = nums.length - 1;
        // Pivot is unknown so make decisions accordingly
        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (nums[mid] > target) {

            } else if (nums[mid] < target) {

            } else {
                return mid;
            }
        }
        return -1;
    }
}
