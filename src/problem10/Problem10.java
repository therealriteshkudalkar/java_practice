package problem10;

public class Problem10 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j = j - 1;
            } else {
                i = i + 1;
            }
        }
        return null;
    }
}
