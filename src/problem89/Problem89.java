package problem89;

import java.util.Arrays;

public class Problem89 {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Sort the tokens in ascending order
        Arrays.sort(tokens);

        int i = 0;
        int j = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                score++;
                power -= tokens[i];
                i++;
            } else {
                if (score > 0) {
                    score--;
                    power += tokens[j];
                    j--;
                } else {
                    break;
                }
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
