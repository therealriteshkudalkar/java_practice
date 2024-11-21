package problem43;

public class Problem43 {
    public int climbStairsOptimized(int n) {
        if (n < 2) {
            return 1;
        }
        int stairsCountForOneStep = 1;
        int stairsCountForTwoSteps = 1;
        int finalStairsCount = 0;
        for (int i = 2; i <= n; i++) {
            finalStairsCount = stairsCountForOneStep + stairsCountForTwoSteps;
            stairsCountForOneStep = stairsCountForTwoSteps;
            stairsCountForTwoSteps = finalStairsCount;
        }
        return finalStairsCount;
    }

    public int climbStairs(int n) {
        int[] numOfStairs = new int[n + 1];
        numOfStairs[0] = 1;
        numOfStairs[1] = 1;
        for (int i = 2; i <= n; i++) {
            // For i: I have two choices I can take 'i - 2' steps and I can take 'i - 1' steps
            numOfStairs[i] = numOfStairs[i - 1] + numOfStairs[i - 2];
        }
        return numOfStairs[n];
    }
}
