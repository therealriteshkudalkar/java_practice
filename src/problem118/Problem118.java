package problem118;

import java.util.HashSet;

public class Problem118 {
    private int findTwoRaisedTo(int pow) {
        int res = 1;
        for (int i = 0; i < pow; i++) {
            res = res * 2;
        }
        return res;
    }

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            set.add(sub);
        }
        return set.size() == findTwoRaisedTo(k);
    }
}
