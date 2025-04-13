package problem58;

public class Problem58 {
    public int singleNumber(int[] nums) {
        int[] countBits = new int[32];
        for (int num: nums) {
            for (int i = 31; i >= 0; i--) {
                countBits[i] += (num & (1 << i)) != 0 ? 1 : 0;
            }
        }
        int ans = 0;
        for(int i = 31; i >= 0; i--) {
            if (countBits[i] % 3 == 1) {
                ans += 1 << i;
            }
        }
        return ans;
    }
}
