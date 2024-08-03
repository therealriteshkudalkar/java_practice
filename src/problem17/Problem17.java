package problem17;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int firstRowIndex = 0;
        int firstColumnIndex = 0;
        int lastRowIndex = m - 1;
        int lastColumnIndex = n - 1;

        while (list.size() < m * n) {
            // move in the first row
            for(int currentColumIndex = firstColumnIndex; currentColumIndex <= lastColumnIndex; currentColumIndex++) {
                list.add(matrix[firstRowIndex][currentColumIndex]);
            }

            // move in the last column
            for(int currentRowIndex = firstRowIndex + 1; currentRowIndex <= lastRowIndex; currentRowIndex++) {
                list.add(matrix[currentRowIndex][lastColumnIndex]);
            }

            // move in the last row
            if (firstRowIndex != lastRowIndex) {
                for (int currentColumnIndex = lastColumnIndex - 1; currentColumnIndex >= firstColumnIndex;
                     currentColumnIndex--) {
                    list.add(matrix[lastRowIndex][currentColumnIndex]);
                }
            }

            // move in the first column
            if (firstColumnIndex != lastColumnIndex) {
               for(int currentRowIndex = lastRowIndex - 1; currentRowIndex > firstRowIndex; currentRowIndex--) {
                   list.add(matrix[currentRowIndex][firstColumnIndex]);
               }
            }

            // increment the first row & column indices
            firstRowIndex++;
            firstColumnIndex++;
            // decrement the last row & last column indices;
            lastRowIndex--;
            lastColumnIndex--;
        }

        return list;
    }
}
