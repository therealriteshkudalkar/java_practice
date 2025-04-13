package problem92;

public class Problem92 {
    private final int MOD = 1_000_000_007;
    private int numOfArraysMemoized(Integer[][][] memo, int n, int m, int k, int index, int searchCost, int maxSoFar) {
        if (index == n) {
            return searchCost == k ? 1 : 0;
        }
        if (memo[index][searchCost][maxSoFar] != null) {
            return memo[index][searchCost][maxSoFar];
        }
        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxSoFar) {
                if (searchCost + 1 > k) {
                    break;
                }
                result = (result + numOfArraysMemoized(memo, n, m, k, index + 1, searchCost + 1, i)) % MOD;
            } else {
                result = (result + numOfArraysMemoized(memo, n, m, k, index + 1, searchCost, maxSoFar)) % MOD;
            }
        }

        memo[index][searchCost][maxSoFar] = result % MOD;
        return result % MOD;
    }

    private int numOfArraysRec(int n, int m, int k, int index, int searchCost, int maxSoFar) {
        if (index == n) {
            return searchCost == k ? 1 : 0;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxSoFar) {
                result = (result + numOfArraysRec(n, m, k, index + 1, searchCost + 1, i)) % 1000000007;
            } else {
                result = (result + numOfArraysRec(n, m, k, index + 1, searchCost, maxSoFar)) % 1000000007;
            }
        }
        return result;
    }

    public int numOfArrays(int n, int m, int k) {
        // return numOfArraysRec(n, m, k, 0, 0, 0);

        Integer[][][] memo = new Integer[n + 1][k + 1][m + 1];
        return numOfArraysMemoized(memo, n, m, k, 0, 0, 0);
    }
}
