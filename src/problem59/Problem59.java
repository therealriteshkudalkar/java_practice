package problem59;

public class Problem59 {
    public int[] singleNumber(int[] nums) {
        int xorVal = 0;
        for(int num: nums) {
            xorVal = xorVal ^ num;
        }
        // Do something to obtain the two numbers
        int[] singleNums = new int[2];
        return singleNums;
    }
}
