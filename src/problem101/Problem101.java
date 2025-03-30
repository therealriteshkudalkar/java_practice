package problem101;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem101 {
    record Direction(int x, int y) {}
    record Pair(int i, int j) {}
    record Elevation(int elevation, Pair position) {}

    public int swimInWater(int[][] grid) {
        int M = grid.length;  // Rows
        int N = grid[0].length;  // Columns
        Direction[] directions = new Direction[]{
                new Direction(-1, 0),
                new Direction(1, 0),
                new Direction(0, -1),
                new Direction(0, 1)
        };
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<Elevation> queue = new PriorityQueue<>(Comparator.comparingInt(Elevation::elevation));
        queue.add(new Elevation(grid[0][0], new Pair(0, 0)));
        visited[0][0] = true;

        int maxValue = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            Elevation currentElevation = queue.poll();
            maxValue = Math.max(maxValue, currentElevation.elevation);

            if (currentElevation.position.i == M - 1 && currentElevation.position.j == N - 1) {
                return maxValue;
            }

            for (Direction direction: directions) {
                int i = direction.x + currentElevation.position.i;
                int j = direction.y + currentElevation.position.j;

                if (0 <= i && i < M && 0 <= j && j < N && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Elevation(grid[i][j], new Pair(i, j)));
                }
            }
        }
        return -1;
    }
}
