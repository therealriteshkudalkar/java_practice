package problem70;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem70 {
    public int orangesRotting(int[][] grid) {
        // Count the number of fresh oranges
        // To a queue add the number of rotten oranges
        record GridCoordinates(int row, int col) {}

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<GridCoordinates> queue = new ArrayDeque<>();
        int freshOrangeCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshOrangeCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new GridCoordinates(i, j));
                }
            }
        }
        int minutesElapsed = 0;
        // Start the multi-source BFS
        while(!queue.isEmpty() && freshOrangeCount > 0) {
            minutesElapsed++;
            // Explore all the currently rotten oranges
            int currentlyRottenOrange = queue.size();
            for (int i = 0; i < currentlyRottenOrange; i++) {
                GridCoordinates currentRottenOrangeCoordinates = queue.poll();
                // Make all the fresh oranges adjacent to it as rotten
                for(int[] direction: directions) {
                    assert currentRottenOrangeCoordinates != null;
                    int row = currentRottenOrangeCoordinates.row + direction[0];
                    int col = currentRottenOrangeCoordinates.col + direction[1];

                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshOrangeCount--;

                        // Add this rotten orange to the queue
                        queue.add(new GridCoordinates(row, col));
                    }
                }
            }
        }
        return freshOrangeCount == 0 ? minutesElapsed : -1;
    }
}
