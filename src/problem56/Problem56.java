package problem56;

public class Problem56 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] pathCount = new int[m + 1][n + 1];

        // If there is at least on path in row or colum with obstacle, we cannot reach the grid
        // Update 1st row
        boolean obstacleFlag = false;
        for (int j = 1; j <= n; j++) {
            if (!obstacleFlag) {
                obstacleFlag = obstacleGrid[0][j - 1] == 1;
            }
            if (!obstacleFlag) {
                pathCount[1][j] = 1;
            } else {
                pathCount[1][j] = 0;
            }
        }

        // Update 1st column
        obstacleFlag = false;
        for (int i = 1; i <= m; i++) {
            if (!obstacleFlag) {
                obstacleFlag = obstacleGrid[i - 1][0] == 1;
            }
            if (!obstacleFlag) {
                pathCount[i][1] = 1;
            } else {
                pathCount[i][1] = 0;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (i == 1 || j == 1) {
                    continue;
                }
                boolean isObstaclePresent = obstacleGrid[i - 1][j - 1] == 1;
                if (isObstaclePresent) {
                    pathCount[i][j] = 0;
                    continue;
                }
                pathCount[i][j] = (obstacleGrid[i - 2][j - 1] == 0 ? pathCount[i - 1][j] : 0) +
                        (obstacleGrid[i - 1][j - 2] == 0 ? pathCount[i][j - 1] : 0);
            }
        }
        return pathCount[m][n];
    }
}
