package problem49;

public class Problem49 {
    public int[] searchRange(int[] nums, int target) {
        // Find the highest index for which target > item at index
        int lb = 0;
        int ub = nums.length - 1;
        int mid1 = (lb + ub) / 2;
        boolean targetFound = false;
        while (lb <= ub) {
            mid1 = (lb + ub) / 2;
            if (target > nums[mid1]) {
                lb = mid1 + 1;
            } else if (target < nums[mid1]) {
                ub = mid1 - 1;
            } else {
                // Found the target now move towards left to find the index where target > mid-item
                targetFound = true;
                if (mid1 == 0 || target > nums[mid1 - 1]) {
                    break;
                } else {
                    ub = mid1 - 1;
                }
            }
        }
        if (!targetFound) {
            return new int[]{-1, -1};
        }
        // Find the lowest index for which target < item at index
        lb = 0;
        ub = nums.length - 1;
        int mid2 = (lb + ub) / 2;
        while (lb <= ub) {
            mid2 = (lb + ub) / 2;
            if (target > nums[mid2]) {
                lb = mid2 + 1;
            } else if (target < nums[mid2]) {
                ub = mid2 - 1;
            } else {
                // Found the target now move towards right to find the index where target < mid-item
                if (mid2 == nums.length - 1 || target < nums[mid2 + 1]) {
                    break;
                } else {
                    lb = mid2 + 1;
                }
            }
        }
        return new int[]{mid1, mid2};
    }
}
