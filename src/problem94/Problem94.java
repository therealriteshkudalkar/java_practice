package problem94;

import java.util.Arrays;

public class Problem94 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // Form an array in which we store remaining capacity
        int[] remainingCapacity = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            remainingCapacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remainingCapacity);
        int fullBags = 0;
        for (int i = 0; i < remainingCapacity.length; i++) {
            if (remainingCapacity[i] == 0) {
                fullBags++;
                continue;
            }
            if (additionalRocks >= remainingCapacity[i]) {
                fullBags++;
                additionalRocks -= remainingCapacity[i];
                remainingCapacity[i] = 0;
                if (additionalRocks == 0) {
                    break;
                }
            }
        }
        return fullBags;
    }
}
