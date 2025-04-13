package problem28;

import java.util.HashMap;

public class Problem28 {
    private int calculateCostMemoized(HashMap<String, Integer> map, int[][] cost, int houseIndex, int previousColourIndex) {
        if (houseIndex >= cost.length) {
            return 0;
        }
        String key = houseIndex + "," + previousColourIndex;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < cost[0].length; i++) {
            if (previousColourIndex != i) {
                minCost =  Math.min(minCost, cost[houseIndex][i] + calculateCostMemoized(map, cost, houseIndex + 1, i));
            }
        }
        map.put(key, minCost);
        return minCost;
    }

    private int calculateCostRec(int[][] cost, int houseIndex, int previousColourIndex) {
        if (houseIndex >= cost.length) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < cost[0].length; i++) {
            if (previousColourIndex != i) {
                minCost =  Math.min(minCost, cost[houseIndex][i] + calculateCostRec(cost, houseIndex + 1, i));
            }
        }
        return minCost;
    }

    int calculateMinimumCost(int[][] cost) {
        // Given n x 3 matrix, I have a choice to make at every index
        // At first index I can choose first colour
        //  Given that I have chosen the first colour for first item
        //    I have two choices to make for second item i.e. either I can select second colour or third colour

        // return calculateCostRec(cost, 0, -1);
        return calculateCostMemoized(new HashMap<>(), cost, 0, -1);
    }
}
