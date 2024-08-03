package problem13;

public class Problem13 {
    /*
    * We can use the left product and right product method.
    * We calculate the left product for each index and right product for each index and store them
    * in two different arrays
    */
    public int[] productExceptSelf(int[] nums) {
        int[] productNums = new int[nums.length];
        // One problem can be solved by multiplying the numbers all together
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            if (leftIndex == 0) {
                leftProduct[leftIndex] = 1;
            } else {
                leftProduct[leftIndex] = leftProduct[leftIndex - 1] * nums[leftIndex - 1];
            }
            int rightIndex = nums.length - 1 - leftIndex;
            if (rightIndex == nums.length - 1) {
                rightProduct[rightIndex] = 1;
            } else {
                rightProduct[rightIndex] = rightProduct[rightIndex + 1] * nums[rightIndex + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            productNums[i] = leftProduct[i] * rightProduct[i];
        }
        return productNums;
    }

    /*
    * Now instead of using the left product array and the right product array, we can use the output
    * array as one of the two i.e. either left product array or right product array and create the other
    * array on fly
    */
    public int[] productExceptSelfOptimized(int[] nums) {
        int[] productArray = new int[nums.length];
        // Create the left array inside the productArray
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                productArray[i] = 1;
                continue;
            }
            productArray[i] = productArray[i - 1] * nums[i - 1];
        }
        // Create the right array on the fly and multiply it with the left array inside the productArray
        int rightProductValue = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (i == nums.length - 1) {
                continue;
            }
            rightProductValue = rightProductValue * nums[i + 1];
            productArray[i] *= rightProductValue;
        }
        return productArray;
    }
}
