package problem24;

import java.util.HashMap;

public class Problem24 {

    /*
    ** The return value represents the number of coins
     */
    private int coinChangeWithIndex(int[] coins, int amount, int index) {
        if (index >= coins.length || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // choose the coin at current index
        int withCoinAtIndex = coinChangeWithIndex(coins, amount - coins[index], index);

        // skip the coin at current index
        int withoutCoinAtIndex = coinChangeWithIndex(coins, amount, index + 1);

        if (withCoinAtIndex != -1 && withoutCoinAtIndex != -1) {
            // We got a case where number of coins don't amount to the required sum
            return Math.min(1 + withCoinAtIndex, withoutCoinAtIndex);
        } else if (withCoinAtIndex == -1 && withoutCoinAtIndex != -1) {
            return withoutCoinAtIndex;
        } else if (withCoinAtIndex != -1) {
            return withCoinAtIndex + 1;
        } else {
            return -1;
        }
    }

    private int coinChangeWithIndexMemoized(HashMap<String, Integer> memo, int[] coins, int amount, int index) {
        String key = String.format("%d,%d", amount, index);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index >= coins.length || amount < 0) {
            memo.put(key, -1);
            return -1;
        }
        if (amount == 0) {
            memo.put(key, 0);
            return 0;
        }

        // choose the coin at current index
        int withCoinAtIndex = coinChangeWithIndexMemoized(memo, coins, amount - coins[index], index);

        // skip the coin at current index
        int withoutCoinAtIndex = coinChangeWithIndexMemoized(memo, coins, amount, index + 1);

        // If none of the below if else statements execute, then we got a case where number of coins
        // don't amount to the required sum
        int returnValue = -1;

        if (withCoinAtIndex != -1 && withoutCoinAtIndex != -1) {
            returnValue = Math.min(1 + withCoinAtIndex, withoutCoinAtIndex);
        } else if (withCoinAtIndex == -1 && withoutCoinAtIndex != -1) {
            returnValue = withoutCoinAtIndex;
        } else if (withCoinAtIndex != -1) {
            returnValue = withCoinAtIndex + 1;
        }
        memo.put(key, returnValue);
        return returnValue;
    }

    private int coinChangeWithIndexTabulated(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] coinsRequired = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            coinsRequired[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    // Take care of saturated addition
                    if (coinsRequired[i - coin] == Integer.MAX_VALUE) {
                        continue;
                    }
                    coinsRequired[i] = Math.min(coinsRequired[i], 1 + coinsRequired[i - coin]);
                }
            }
        }
        return coinsRequired[amount] == Integer.MAX_VALUE ? -1 : coinsRequired[amount];
    }

    public int coinChange(int[] coins, int amount) {
        // return coinChangeWithIndex(coins, amount, 0);
        // return coinChangeWithIndexMemoized(new HashMap<>(), coins, amount, 0);
        return coinChangeWithIndexTabulated(coins, amount);
    }
}
