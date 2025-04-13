package problem95;

public class Problem95 {
    public String printLongestCommonSubsequence(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return "";
        }
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i + 1][j + 1] = 1 + memo[i][j];
                } else {
                    memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder builder = new StringBuilder();
        while(i > 0 && j > 0) {
            char ch1 = text1.charAt(i - 1);
            char ch2 = text2.charAt(j - 1);
            if (ch1 == ch2) {
                // Add the character to the end of the string
                builder.append(ch1);
                i--;
                j--;
            } else {
                if (memo[i - 1][j] > memo[i][j - 1]) {
                    i--;
                } else {
                    j --;
                }
            }
        }
        return builder.reverse().toString();
    }

    private int longestCommonSubsequenceTabulated(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i + 1][j + 1] = 1 + memo[i][j];
                } else {
                    memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }
        return memo[text1.length()][text2.length()];
    }

    private int longestCommonSubsequenceMemoized(Integer[][]memo, String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + longestCommonSubsequenceMemoized(memo, text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(
                    longestCommonSubsequenceMemoized(memo, text1, text2, i + 1, j),
                    longestCommonSubsequenceMemoized(memo, text1, text2, i, j + 1)
            );
        }
        return memo[i][j];
    }

    private int longestCommonSubsequenceRec(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + longestCommonSubsequenceRec(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(
                    longestCommonSubsequenceRec(text1, text2, i + 1, j),
                    longestCommonSubsequenceRec(text1, text2, i, j + 1)
            );
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // return longestCommonSubsequenceRec(text1, text2, 0, 0);
        // return longestCommonSubsequenceMemoized(new Integer[text1.length() + 1][text2.length() + 1], text1, text2, 0, 0);
        return longestCommonSubsequenceTabulated(text1, text2);
    }
}
