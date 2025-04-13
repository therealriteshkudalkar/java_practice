package problem100;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Problem100 {
    record Direction(int x, int y) {}
    record Pair(int i, int j) {}
    record Elevation(int elevation, Pair pair){}

    public int getMaximumOfMinimumPathElevation(int[][] elevation) {
        int M = elevation.length;
        int N = elevation[0].length;

        Direction[] directions = new Direction[]{
                new Direction(-1, 0),
                new Direction(1, 0),
                new Direction(0, -1),
                new Direction(0, 1)
        };

        boolean[][] visited = new boolean[M][N]; // Is already initialized to false

        PriorityQueue<Elevation> queue = new PriorityQueue<>(Comparator.comparingInt(Elevation::elevation).reversed());
        queue.add(new Elevation(elevation[0][0], new Pair(0, 0)));
        visited[0][0] = true;

        int minValue = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Elevation currentElevation = queue.poll();
            minValue = Math.min(minValue, currentElevation.elevation);

            if (currentElevation.pair.i == M - 1 && currentElevation.pair.j == N - 1) {
                return minValue;
            }

            for(Direction direction: directions) {
                int i = direction.x + currentElevation.pair.i;
                int j = direction.y + currentElevation.pair.j;

                if (0 <= i && i < M && 0 <= j && j < N && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new Elevation(elevation[i][j], new Pair(i, j)));
                }
            }
        }

        return -1;
    }
}
