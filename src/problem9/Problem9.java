package problem9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem9 {

    private void permutationWithoutRepetition(HashSet<Integer> indices, List<String> list, String permutation, String str) {
        if (permutation.length() == str.length()) {
            list.add(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (indices.contains(i)) {
                // Then skip the current item
                continue;
            }
            char ch = str.charAt(i);
            indices.add(i);
            permutationWithoutRepetition(indices, list, permutation + ch, str);
            indices.remove(i);
        }
    }

    /*
     *  Here we assume that the required length of permutation is equal to the length of the string
     *  @param String str:
     */

    public List<String> permutationWithoutRepetition(String str) {
        List<String> list = new ArrayList<>();
        permutationWithoutRepetition(new HashSet<>(), list, "", str);
        return list;
    }

    private void permutationWithRepetition(List<String> list, String permutation, String str) {
        if (permutation.length() == str.length()) {
            list.add(permutation);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            permutationWithRepetition(list, permutation + ch, str);
        }
    }

    public List<String> permutationWithRepetition(String str) {
        List<String> list = new ArrayList<>();
        permutationWithRepetition(list, "", str);
        return list;
    }

    private void combinationWithRepetition(List<String> list, String combination, String str) {
        if (combination.length() == str.length()) {
            list.add(combination);
        }
    }

    private List<String> combinationWithRepetition(String str) {
        List<String> list = new ArrayList<>();
        combinationWithRepetition(list, "", str);
        return list;
    }
}
