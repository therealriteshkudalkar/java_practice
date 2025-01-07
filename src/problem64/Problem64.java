package problem64;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem64 {
    public int numIslands(char[][] grid) {
        // Convert the grid into a graph with certain edges
        record GridCoordinate(int row, int col){}

        // We can move in four directions
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    // Start a DFS on this graph
                    Queue<GridCoordinate> queue = new ArrayDeque<>();
                    queue.add(new GridCoordinate(i, j));
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        GridCoordinate currentNode = queue.poll();

                        // Check if any of its neighbours (in all directions) is 1
                        for (int[] direction : directions) {
                            int row = currentNode.row + direction[0];
                            int col = currentNode.col + direction[1];
                            if (row >= 0 && row < grid.length && col >= 0 && col < grid[i].length && grid[row][col] == '1') {
                                grid[row][col] = '0';
                                // Add it to the queue
                                queue.add(new GridCoordinate(row, col));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
