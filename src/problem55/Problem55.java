package problem55;

import java.util.HashMap;

public class Problem55 {

    private int uniquePathsTabulated(int m, int n) {
        int[][] pathCount = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    pathCount[i][j] = 1;
                } else {
                    pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
                }
            }
        }
        return pathCount[m][n];
    }

    private int uniquePathsMemoized(HashMap<String, Integer> memo, int m, int n) {
        String key = String.format("%d,%d", m, n);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int sum = uniquePathsMemoized(memo, m - 1, n) + uniquePathsMemoized(memo, m, n - 1);
        memo.put(key, sum);
        return sum;
    }

    private int uniquePathsRec(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePathsRec(m - 1, n) + uniquePathsRec(m, n - 1);
    }

    public int uniquePaths(int m, int n) {
        // return uniquePathsRec(m, n);
        // return uniquePathsMemoized(new HashMap<>(), m, n);
        return uniquePathsTabulated(m, n);
    }
}
