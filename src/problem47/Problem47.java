package problem47;

public class Problem47 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find a row in which the first item is greater than equal to the target and the next row
        int rowLower = 0;
        int rowUpper = matrix.length - 1;
        int rowMid = (rowLower + rowUpper) / 2;
        while(rowLower <= rowUpper) {
            rowMid = (rowLower + rowUpper) / 2;
            if (target < matrix[rowMid][0]) {
                if (rowMid == 0) {
                    return false;
                }
                rowUpper = rowMid - 1;
            } else if (target > matrix[rowMid][0]) {
                if (rowMid == matrix.length - 1 || target < matrix[rowMid + 1][0]) {
                    break;
                }
                rowLower = rowMid + 1;
            } else {
                return true;
            }
        }
        // Inside the row, search the item
        int columnLower = 0;
        int columnUpper = matrix[0].length - 1;
        while(columnLower <= columnUpper) {
            int columnMid = (columnLower + columnUpper) / 2;
            if (matrix[rowMid][columnMid] > target) {
                columnUpper = columnMid - 1;
            } else if (matrix[rowMid][columnMid] < target) {
                columnLower = columnMid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
