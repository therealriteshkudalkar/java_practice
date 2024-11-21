package problem42;

import java.util.HashMap;

public class Problem42 {
    // Axiom: The required substring from s will always start with one of the characters of t. Think why?
    public String minWindowOptimized(String s, String t) {
        int left = 0;
        int right = 0;
        while (right < s.length()) {

        }
        return "";
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            tCount.put(currentChar, tCount.getOrDefault(currentChar, 0) + 1);
        }
        String minSubstring = null;
        // Find all substrings of s
        // For each substring check if count of characters match
        // // If yes, check the length of the substring
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                String currentSubstring = s.substring(i, j);
                HashMap<Character, Integer> currentSubstringMap = new HashMap<>();
                // Calculate and check if the map matches
                for (int k = 0; k < currentSubstring.length(); k++) {
                    char currChar = currentSubstring.charAt(k);
                    currentSubstringMap.put(currChar, currentSubstringMap.getOrDefault(currChar, 0) + 1);
                }
                // Go through each character of tCount and check if the count is at least as much
                boolean areEntriesMatching = true;
                for (var entry: tCount.entrySet()) {
                    // First check if the character is present
                    if (!currentSubstringMap.containsKey(entry.getKey())) {
                        areEntriesMatching = false;
                        break;
                    } else {
                        if (currentSubstringMap.get(entry.getKey()) >= entry.getValue()) {
                            continue;
                        }
                        areEntriesMatching = false;
                        break;
                    }
                }
                if (areEntriesMatching) {
                    if (minSubstring == null) {
                        minSubstring = currentSubstring;
                    } else {
                        if (minSubstring.length() > currentSubstring.length()) {
                            minSubstring = currentSubstring;
                        }
                    }
                }
            }
        }
        return minSubstring == null ? "": minSubstring;
    }
}
