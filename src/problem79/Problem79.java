package problem79;

public class Problem79 {
    public void sortColors(int[] nums) {
        int redIndex = -1; // 0 - red
        int whiteIndex = -1, whiteCount = 0; // 1 - blue
        int blueIndex = -1, blueCount = 0; // 2 -
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // If red colour is added
                // Add the colours accordingly
                nums[++redIndex] = 0;
                // If white is found then increment its index as well and make that as 1
                if (whiteCount != 0) {
                    nums[++whiteIndex] = 1;
                } else {
                    whiteIndex++;
                }
                // If blue is found then increment its index as well and make that as 1
                if (blueCount != 0) {
                    nums[++blueIndex] = 2;
                } else {
                    blueIndex++;
                }
            } else if (nums[i] == 1) {
                whiteCount++;
                nums[++whiteIndex] = 1;
                // If blue is found then increment its index as well and make that as 1
                if (blueCount != 0) {
                    nums[++blueIndex] = 2;
                } else {
                    blueIndex++;
                }
            } else if (nums[i] == 2) {
                blueCount++;
                nums[++blueIndex] = 2;
            }
        }
    }
}
