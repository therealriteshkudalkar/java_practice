package problem26;

import java.util.ArrayList;
import java.util.List;

public class Problem26 {
    /*
    *
    * Example1
    * A   E
    * B D F
    * C   G
    *
    * Example2
    * A       I
    * B     H J
    * C   G   K
    * D F     L N
    * E       M
    *
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        // First create an array
        List<List<Character>> array = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            array.add(new ArrayList<>());
        }

        // Traverse the character one by one
        int i = 0, j = 0;
        for (int chIndex = 0; chIndex < s.length(); ) {
            if (j % (numRows - 1) == 0) {
                // When j % (numRows - 1) is zero then print all characters regularly
                array.get(i).add(s.charAt(chIndex));
                chIndex++;
            } else {
                // When j % (numRows - 1) is not zero then print characters sparingly
                if (i == (numRows - 1 - (j % (numRows - 1)))) {
                    array.get(i).add(s.charAt(chIndex));
                    chIndex++;
                }
            }
            i = (i + 1) % numRows;
            if (i == 0) {
                j++;
            }
        }

        // Build the new string
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : array) {
            for (Character c : row) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

