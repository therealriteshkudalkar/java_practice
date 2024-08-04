package problem19;

public class Problem19 {
    public void rotate(int[][] matrix) {
        // Rotate outermost array and then towards innermost array until you reach the middle
        int n = matrix.length;
        int rowFirstIndex = 0;
        int rowLastIndex = n - 1;
        int columnFirstIndex = 0;
        int columnLastIndex = n - 1;

        // how will you know whether you have reached the based condition?
        // in the base condition rowFirstIndex <= rowLastIndex and

        // variable 'i' represents the current ring we are in
        for (int i = n; i > n / 2; i -= 2) {
            // variable 'j' represents the number of time the current ring is to be shifted
            // Shift each ring by 1 position and do it i times for a 90 degree shift where i reduces from n to 1
            for (int j = 1; j < 5 * i; j++) {
                // shift the first row
                int temp = matrix[rowFirstIndex][columnFirstIndex];

                for (int currentColIndex = columnFirstIndex + 1; currentColIndex <= columnLastIndex; currentColIndex++) {
                    matrix[rowFirstIndex][currentColIndex - 1] = matrix[rowFirstIndex][currentColIndex];
                }

                // shift the last column
                for (int currentRowIndex = rowFirstIndex + 1; currentRowIndex <= rowLastIndex; currentRowIndex++) {
                    matrix[currentRowIndex - 1][columnLastIndex] = matrix[currentRowIndex][columnLastIndex];
                }

                // shift the last row
                for (int currentColIndex = columnLastIndex - 1; currentColIndex >= columnFirstIndex; currentColIndex--) {
                    matrix[rowLastIndex][currentColIndex + 1] = matrix[rowLastIndex][currentColIndex];
                }

                // shift the first column
                for (int currentRowIndex = rowLastIndex - 1; currentRowIndex > rowFirstIndex; currentRowIndex--) {
                    matrix[currentRowIndex + 1][columnFirstIndex] = matrix[currentRowIndex][columnFirstIndex];
                }

                // make sure that the element which is stored in temp is assigned properly
                matrix[rowFirstIndex + 1][columnFirstIndex] = temp;
            }

            // Alter the boundaries of the ring
            rowFirstIndex++;
            rowLastIndex--;
            columnFirstIndex++;
            columnLastIndex--;
        }
    }

    public void rotateOptimized(int[][] matrix) {
        // Take transpose of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i< matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int lastIndex = matrix.length - 1 - j;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][lastIndex];
                matrix[i][lastIndex] = temp;
            }
        }
    }
}
