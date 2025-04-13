package problem51;

import java.util.Arrays;

public class Problem51 {
    private int binarySearch(int[] arr, int target, int lb, int ub) {
        while(lb <= ub) {
            int mid = (lb + ub) / 2;
            if (arr[mid] > target) {
                ub = mid - 1;
            } else if (arr[mid] < target) {
                lb = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int lb = 0, ub = n - 1;
        // Find the pivot position using binary search
        // The pivotIndex is also the index of the smallest number in the array
        // For a pivot element (target element) the left of this element will be greater than the number
        // i.e. find number for which the left element is 1
        // pivot on right half => 3, 4, 5,    6, 0, 1, 2
        // pivot on left half  => 5, 6, 1, 2, 3, 4, 5

        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (nums[mid] > nums[n - 1]) {
                // the pivot lies in the right subarray
                lb = mid + 1;
            } else  {
                ub = mid - 1;
            }
        }

        // Find the target either in the (pivotIndex, nums.length) or (0, pivotIndex - 1):
        // binary search on 0 to pivot
        // binary search on pivot to n - 1
        int index = binarySearch(nums, target, 0, lb - 1);
        if (index == -1) {
            index = binarySearch(nums, target, lb, nums.length - 1);
        }
        return index;
    }
}
