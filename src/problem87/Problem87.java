package problem87;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Problem87 {
    private int longestStrChainGreedy(String[] words) {
        // Sort the words according to the size
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Put the words in a map
        int maxChainLength = 1;
        HashMap<String, Integer> wordChainCount = new HashMap<>();
        for (String word: words) {
            // for this word, delete element one by one and check if it is present in
            wordChainCount.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                // Remove the char at this position and create a string
                String newWord = word.substring(0, i) + word.substring(i + 1);

                if (wordChainCount.containsKey(newWord)) {
                    // We can extend the chain
                    int newChainCount = 1 + wordChainCount.get(newWord);
                    wordChainCount.put(word, Math.max(wordChainCount.get(word), newChainCount));
                    maxChainLength = Math.max(maxChainLength, newChainCount);
                }
            }
        }
        return maxChainLength;
    }

    public int longestStrChain(String[] words) {
        return longestStrChainGreedy(words);
    }
}
