package problem85;

public class Problem85 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSquareMatrixLength = Math.min(m, n);
        int[][] directions = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        boolean[][][] memo = new boolean[maxSquareMatrixLength + 1][m][n];
        int max = 0;
        for (int s = 1; s <= maxSquareMatrixLength; s++) {
            if (s == 1) {
                for(int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        memo[s][i][j] = matrix[i][j] == '1';
                        if (memo[s][i][j]) {
                            max = Math.max(max, s * s);
                        }
                    }
                }
                continue;
            }

            // For each size of the square matrix, there will be (n + 1 - i) * (n + 1 - i) square matrices
            for (int i = 0; i <= m - s; i++) {
                for(int j = 0; j <= n - s; j++) {
                    // Each matrix of frame of size i is dependent on four matrices of size i - 1
                    boolean flag = true; // Assume all are one
                    for (int[] direction: directions) {
                        // For each direction find the sub array of (current size - 1) by adding 1 to it and subtracting 1
                        if (!memo[s - 1][i + direction[0]][j + direction[1]]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        max = Math.max(max, s * s);
                    }
                    memo[s][i][j] = flag;
                }
            }
        }
        return max;
    }
}
