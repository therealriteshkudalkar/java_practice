package problem117;

import java.util.ArrayList;
import java.util.List;

public class Problem117 {

    private void letterCasePermutationHelper(List<String> result, String s, String current, int index) {
        if (index >= s.length()) {
            result.add(current);
            return;
        }

        if (Character.isLetter(s.charAt(index))) {
            letterCasePermutationHelper(result, s, current + Character.toLowerCase(s.charAt(index)), index + 1);
            letterCasePermutationHelper(result, s, current + Character.toUpperCase(s.charAt(index)), index + 1);
        } else {
            letterCasePermutationHelper(result, s, current + s.charAt(index), index + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        letterCasePermutationHelper(result, s, "", 0);
        return result;
    }
}
