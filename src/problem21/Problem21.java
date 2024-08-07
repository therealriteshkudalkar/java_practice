package problem21;

public class Problem21 {
    public int getLiveNeighbours(int[][] board, int i, int j) {
        // move through row
        int m = board.length;
        int n = board[i].length;

        int k = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {
                    k++;
                }
            }
        }
        return k;
    }

    public void gameOfLife(int[][] board) {
        // Copying
        int m = board.length;
        int n = board[0].length;
        int[][] initialBoard = new int[m][n];
        for (int i = 0; i < m; i++) {
            // copy the board
            System.arraycopy(board[i], 0, initialBoard[i], 0, n);
        }

        // Altering the board variable according to the rules
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // alter the element according to the rules
                // count the number of live neighbours
                int k = getLiveNeighbours(initialBoard, i, j);
                if (k < 2) {
                    board[i][j] = 0;
                } else if (k == 2 || k == 3) {
                    if (board[i][j] == 0 && k == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int getLiveNeighboursWithTransitioned(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[i].length;

        int k = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (board[x][y] == 1 || board[x][y] == -2) {
                        k++;
                    }
                }
            }
        }
        return k;
    }

    public void gameOfLifeOptimized(int[][] board) {
        // Labelling transitions
        // 0 -> 0  = 0
        // 1 -> 1 = 1
        // 0 -> 1  = 2
        // 1 -> 0 = -2

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // alter the element according to the rules
                // count the number of live neighbours
                int k = getLiveNeighboursWithTransitioned(board, i, j);
                if (k < 2) {
                    // check how board transitioned
                    if (board[i][j] == 1) {
                        board[i][j] = -2;
                    } else {
                        board[i][j] = 0;
                    }
                } else if (k == 2 || k == 3) {
                    if (board[i][j] == 0 && k == 3) {
                        // board has transitioned from 0 to 1
                        board[i][j] = 2;
                    }
                } else {
                    // check how board has transitioned
                    if (board[i][j] == 1) {
                        board[i][j] = -2;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        // Altering the board another time but this time renaming the transitions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -2) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
