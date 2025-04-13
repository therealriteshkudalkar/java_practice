package problem86;

import java.util.Arrays;
import java.util.HashMap;

public class Problem86 {

    private int findLongestChainTabulated(int[][] pairs) {
        // Go through each pair and their chains
        int[] maximumPairLengths = new int[pairs.length];
        Arrays.fill(maximumPairLengths, 1);
        int maxLength = 1;
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    maximumPairLengths[i] = Math.max(maximumPairLengths[i], 1 + maximumPairLengths[j]);
                    maxLength = Math.max(maxLength, maximumPairLengths[i]);
                }
            }
        }
        return maxLength;
    }

    private int findLongestChainMemoized(HashMap<String, Integer> memo, int[][] pairs, int currentIndex, int previousIndex) {
        String key = String.format("%d,%d", currentIndex, previousIndex);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (currentIndex == pairs.length) {
            return 0;
        }
        int skip = findLongestChainMemoized(memo, pairs, currentIndex + 1, previousIndex);
        int take;
        if (previousIndex == -1) {
            // Take or skip
            take = 1 + findLongestChainMemoized(memo, pairs, currentIndex + 1, currentIndex);
        } else {
            // Take depending on the currentIndex pair & previousIndex pair or skip
            take = pairs[currentIndex][0] > pairs[previousIndex][1] ? 1 + findLongestChainMemoized(memo, pairs, currentIndex + 1, currentIndex) : skip;
        }
        int max = Math.max(take, skip);
        memo.put(key, max);
        return max;
    }

    private int findLongestChainRec(int[][] pairs, int currentIndex, int previousIndex) {
        if (currentIndex == pairs.length) {
            return 0;
        }
        int skip = findLongestChainRec(pairs, currentIndex + 1, previousIndex);
        int take;
        if (previousIndex == -1) {
            take = 1 + findLongestChainRec(pairs, currentIndex + 1, currentIndex);
        } else {
            take = pairs[currentIndex][0] > pairs[previousIndex][1] ? 1 + findLongestChainRec(pairs, currentIndex + 1, currentIndex) : skip;
        }
        return Math.max(skip, take);
    }

    public int findLongestChain(int[][] pairs) {
        // Sort the pairs
        Arrays.sort(pairs, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) {
                return Integer.compare(arr1[0], arr2[0]);
            }
            return Integer.compare(arr1[1], arr2[1]);
        });

        // return findLongestChainRec(pairs, 0, -1);
        // return findLongestChainMemoized(new HashMap<>(), pairs, 0, -1);
        return findLongestChainTabulated(pairs);
    }
}
