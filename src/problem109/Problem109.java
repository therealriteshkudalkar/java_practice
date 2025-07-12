package problem109;

import java.util.Arrays;
import java.util.Comparator;

public class Problem109 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int N = nums1.length;
        int[][] pair = new int[N][2];
        for(int i = 0; i < N; i++) {
            pair[i][0] = nums1[i];
            pair[i][1] = nums2[i];
        }
        Arrays.sort(pair, Comparator.comparingInt((int[] o) -> o[1]).reversed());
        long score = 0;
        for (int i = k - 1; i < N; i++) {
            // Given current minimum
            int currentMinimum = pair[i][1];

            // Find the sum of the numbers from (i-(k-1) to i) and shift the window until (i to i + k - 1)
            int windowSize = 0;
            long prefixSum = 0;
            for (int j = i - (k - 1); j < i + k && j < N; j++) {
                int back = pair[j][0];
                prefixSum += back;
                windowSize++;

                if (windowSize == k) {
                    score = Math.max(score, currentMinimum * prefixSum);
                    int front = pair[j - (k - 1)][0];
                    prefixSum -= front;
                    windowSize--;
                }
            }
        }
        return score;
    }
}
