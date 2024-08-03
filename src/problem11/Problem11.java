package problem11;

import java.util.HashSet;

public class Problem11 {
    void printPermutationsWithoutRepetition(String str, HashSet<Character> set, String currentPermutation) {
        if (currentPermutation.length() == str.length()) {
            System.out.println(currentPermutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) {
                continue;
            }
            set.add(ch);
            printPermutationsWithoutRepetition(str, set, currentPermutation + ch);
            set.remove(ch);
        }
    }
}
