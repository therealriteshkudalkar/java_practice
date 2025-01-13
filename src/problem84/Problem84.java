package problem84;

public class Problem84 {
    public int findPeakElement(int[] nums) {
        int lb = 0;
        int ub = nums.length - 1;
        while(lb < ub) {
            int mid = (lb + ub) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // Mid is on falling slope relative to right neighbour
                ub = mid;
            } else {
                // Mid is on rising slope
                lb = mid + 1;
            }
        }
        return lb;
    }
}
