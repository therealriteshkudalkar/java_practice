package problem102;

public class Problem102 {
    private record Direction(int x, int y) {}

    public int minimumEffortPath(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;

        Direction[] directions = new Direction[]{
                new Direction(1, 0),
                new Direction(-1, 0),
                new Direction(0, 1),
                new Direction(0, -1),
        };
        return 0;
    }
}
