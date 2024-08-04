package problem18;

public class Problem18 {
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    /*
    ** Find two numbers from an array such that the product of distance between them and the minimum of them is maximum.
    **
    ** The two pointer method works because let us assume the best container is formed by line x and line y (x < y).
    ** Then using the two pointer algorithm (head and tail pointer), we know that eventually one of our pointers
    ** will hit x/y sooner than the other pointer. Assume, without loss of generalization, that line y was hit by
    ** the tail pointer, then all we need to prove is that this pointer will stay there until line x was hit by the
    ** head pointer. To prove this, we only need to show that the length of any line that the head pointer points to
    ** currently will always be lower than line y. This is true, because otherwise line x will no longer be in the
    ** best solution since we can form a larger container using line y and the line head pointer currently points to.
    */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            maxArea = Math.max(maxArea, Math.min(leftHeight, rightHeight) * (right - left));
            if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

}
