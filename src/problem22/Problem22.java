package problem22;

import java.util.HashMap;

public class Problem22 {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
    ** Approach:  Perform modulus operation on all the times.
    ** This yields numbers less than 60 then we need to then only check using a map.
    * Need to be careful with keys which are mapped to zero in that case we add map[i] - 1 pairs.
    */
    public int numPairsDivisibleBy60Optimized(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : time) {
            int currentSongTimeModded = j % 60;
            int complementaryOther = 60 - (currentSongTimeModded);
            if (currentSongTimeModded == 0) {
                // found a zero pair
                if (map.containsKey(currentSongTimeModded)) {
                    count += map.getOrDefault(currentSongTimeModded, 0);
                }
            } else {
                // found the complimentary pair, so we can form all the pairs with the current song
                if (map.containsKey(complementaryOther)) {
                    count += map.getOrDefault(complementaryOther, 0);
                }
            }
            map.put(currentSongTimeModded, map.getOrDefault(currentSongTimeModded, 0) + 1);
        }
        return count;
    }
}
