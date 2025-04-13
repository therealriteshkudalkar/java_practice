package problem57;

public class Problem57 {
    public int singleNumber(int[] nums) {
        int soloNum = 0;
        for (int num: nums) {
            soloNum = soloNum ^ num;
        }
        return soloNum;
    }
}
