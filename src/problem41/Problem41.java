package problem41;

import java.util.HashMap;

public class Problem41 {
    private int diff(int[] a) {
        return a[1] - a[0] + 1;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int[] longestSubstring = new int[] {0, 0};
        int[] currentSubstring = new int[] {0, 0};
        // Store the character and the last index on which the character was seen
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= currentSubstring[0]) {
                // currentSubstring has the current character so start a new currentSubstring
                currentSubstring[0] = map.get(c) + 1;
                map.put(c, i);
            } else {
                // currentSubstring doesn't have the character, so add the key to the map
                // and increase the currentSubstring size by 1
                map.put(c, i);
            }
            currentSubstring[1] = i;
            if (diff(currentSubstring) > diff(longestSubstring)) {
                longestSubstring[0] = currentSubstring[0];
                longestSubstring[1] = currentSubstring[1];
            }
        }
        return longestSubstring[1] - longestSubstring[0] + 1;
    }
}
