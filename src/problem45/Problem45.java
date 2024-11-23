package problem45;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class Problem45 {
    public boolean wordBreakBruteForce(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String currentWord = wordDict.get(i);
            if (s.startsWith(currentWord)) {
                boolean result = wordBreakBruteForce(s.substring(currentWord.length()), wordDict);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] seenNodes = new boolean[s.length() + 1];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (seenNodes[end]) {
                    continue;
                }
                if (wordDictSet.contains(s.substring(start, end))) {
                    seenNodes[end] = true;
                    queue.add(end);
                }
            }
        }
        return false;
    }
}
