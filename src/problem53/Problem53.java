package problem53;

import java.util.HashMap;

public class Problem53 {

    private boolean stoneGameMemoizedOptimal(int[] piles) {
        return true;
    }

    private boolean stoneGameMemoized(HashMap<String, Boolean> memo, int[] piles, int firstIndex, int lastIndex, boolean aliceTurn, int aliceCount, int bobCount) {
        String key = String.format("%b,%d,%d,%d,%d", aliceTurn, firstIndex, lastIndex, aliceCount, bobCount);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (firstIndex == lastIndex) {
            boolean value = aliceTurn ? aliceCount + piles[firstIndex] > bobCount : bobCount + piles[firstIndex] < aliceCount;
            memo.put(key, value);
            return value;
        }

        boolean returnValue;
        if (aliceTurn) {
            returnValue = stoneGameMemoized(memo, piles, firstIndex, lastIndex - 1, false, aliceCount + piles[lastIndex], bobCount)
                    || stoneGameMemoized(memo, piles, firstIndex + 1, lastIndex, false, aliceCount + piles[firstIndex], bobCount);
        } else {
            returnValue = stoneGameMemoized(memo, piles, firstIndex, lastIndex - 1, true, aliceCount, bobCount + piles[lastIndex])
                    || stoneGameMemoized(memo, piles, firstIndex + 1, lastIndex, true, aliceCount, bobCount + piles[firstIndex]);
        }

        memo.put(key, returnValue);
        return returnValue;
    }

    private boolean stoneGameRec(int[] piles, int firstIndex, int lastIndex, boolean aliceTurn, int aliceCount, int bobCount) {
        if (firstIndex == lastIndex) {
            return aliceTurn ? aliceCount + piles[firstIndex] > bobCount : bobCount + piles[firstIndex] < aliceCount;
        }

        if (aliceTurn) {
            return stoneGameRec(piles, firstIndex, lastIndex - 1, false, aliceCount + piles[lastIndex], bobCount)
                    || stoneGameRec(piles, firstIndex + 1, lastIndex, false, aliceCount + piles[firstIndex], bobCount);
        } else {
            return stoneGameRec(piles, firstIndex, lastIndex - 1, true, aliceCount, bobCount + piles[lastIndex])
                    || stoneGameRec(piles, firstIndex + 1, lastIndex, true, aliceCount, bobCount + piles[firstIndex]);
        }
    }

    public boolean stoneGame(int[] piles) {
        // Alice starts first
        // return stoneGameRec(piles, 0, piles.length - 1, true, 0, 0);
        // return stoneGameMemoized(new HashMap<>(), piles, 0, piles.length - 1, true, 0, 0);
        return stoneGameMemoizedOptimal(piles);
    }
}
