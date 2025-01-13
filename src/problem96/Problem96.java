package problem96;

import java.util.ArrayList;
import java.util.Random;

public class Problem96 {
    static class Solution1 {
        private final ArrayList<Integer> list;
        private final Random random;
        public Solution1(int[] w) {
            this.random = new Random();
            this.list = new ArrayList<>(w.length);
            for (int i = 0; i < w.length; i++) {
                for(int j = 1; j <= w[i]; j++) {
                    this.list.add(i);
                }
            }
        }

        public int pickIndex() {
            int randomIndex = this.random.nextInt(0, this.list.size());
            return list.get(randomIndex);
        }
    }

    static class Solution2 {
        private final int[] prefixSum;
        private final Random random;
        private int totalCumulativeSum;

        public Solution2(int[] w) {
            this.random = new Random();
            this.prefixSum = new int[w.length];
            this.totalCumulativeSum = 0;

            for (int i = 0; i < w.length; i++) {
                this.prefixSum[i] = this.totalCumulativeSum + w[i];
                this.totalCumulativeSum = this.prefixSum[i];
            }
        }

        public int pickIndex() {
            int randomInTotalCumulativeSum = this.random.nextInt(0, this.totalCumulativeSum);
            for (int i = 0; i < this.prefixSum.length; i++) {
                if (randomInTotalCumulativeSum < prefixSum[i]) {
                    return i;
                }
            }
            return this.prefixSum.length - 1;
        }
    }

    static class Solution3 {
        private final Random random;
        private final int[] prefixSum;
        private int totalCumulativeSum;

        public Solution3(int[] w) {
            this.random = new Random();
            this.prefixSum = new int[w.length];
            this.totalCumulativeSum = 0;

            for (int i = 0; i < w.length; i++) {
                this.prefixSum[i] = this.totalCumulativeSum + w[i];
                this.totalCumulativeSum = this.prefixSum[i];
            }
        }

        public int pickIndex() {
            int randomInTotalCumulativeSum = this.random.nextInt(0, this.totalCumulativeSum);
            int lb = 0;
            int ub = this.prefixSum.length - 1;

            // we want to find the minimum number greater than the target
            int mid;
            while (lb <= ub) {
                // mid to have prefix sum that is larger than randomInTotalCumulativeSum
                mid = (lb + ub) / 2;
                if (randomInTotalCumulativeSum < this.prefixSum[mid]) {
                    ub = mid - 1;
                } else {
                    // randomInTotalCumulativeSum >= this.prefixSum[mid]
                    lb = mid + 1;
                }
            }
            return lb;
        }
    }
}
