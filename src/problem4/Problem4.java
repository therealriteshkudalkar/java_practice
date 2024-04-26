package problem4;

import java.util.HashMap;

public class Problem4 {
    private boolean isMatchWithPrev(HashMap<String, Boolean> memo, String s, String p, char lastStarChar) {
        String key = s + "," + p;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean val = false;
        if (s.isEmpty() && p.isEmpty()) {
            // both s and p are empty
            val = true;
        } else if (s.isEmpty()) {
            // s is empty but p is not empty
            if (p.length() == 1) {
                val = p.charAt(0) == '*';
            } else {
                // check what is the current character if it is zero then do something
                if (p.charAt(1) == '*') {
                    val = isMatchWithPrev(memo, s, p.substring(2), p.charAt(0));
                } else {
                    val = false;
                }
            }
        } else if (p.isEmpty()) {
            // s is not empty but p is empty
            val = false;
        } else {
            // both s and p are not empty
            char cS = s.charAt(0);
            char cP = p.charAt(0);

            if (cP == '*') {
                if (cS == lastStarChar || lastStarChar == '.') {
                    // we have two choices 1) we stay at cP's current index, or we move ahead one step
                    val = isMatchWithPrev(memo, s.substring(1), p.substring(1), lastStarChar)
                            || isMatchWithPrev(memo, s.substring(1), p, lastStarChar)
                            || isMatchWithPrev(memo, s, p.substring(1), lastStarChar);
                } else {
                    // if they characters don't match try to move to next character in P but stay where you are in S
                    val = isMatchWithPrev(memo, s, p.substring(1), lastStarChar);
                }
            } else {
                // cP is not a special character
                if (p.length() > 1) {
                    char lookAheadP = p.charAt(1);
                    if (lookAheadP == '*') {
                        if (cS == cP || cP == '.') {
                            // we have two choices
                            val = isMatchWithPrev(memo, s.substring(1), p.substring(1), cP)
                                    || isMatchWithPrev(memo, s, p.substring(1), cP);
                        } else {
                            val = isMatchWithPrev(memo, s, p.substring(1), cP);
                        }
                    } else {
                        val = (cS == cP || cP == '.')
                                && isMatchWithPrev(memo, s.substring(1), p.substring(1), lastStarChar);
                    }
                } else {
                    // p has length == 1
                    val = (cS == cP || cP == '.')
                            && isMatchWithPrev(memo, s.substring(1), p.substring(1), lastStarChar);
                }
            }
        }
        memo.put(key, val);
        return val;
    }

    public boolean isMatch(String s, String p) {
        return isMatchWithPrev(new HashMap<>(), s, p, '\0');
    }
}
