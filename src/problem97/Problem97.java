package problem97;

public class Problem97 {
    private int findMax(int[] piles) {
        int max = piles[0];
        for (int pile: piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private int minEatingSpeedOptimized(int[] piles, int h) {
        int lb = 1;
        int ub = findMax(piles);

        // Start binary search
        int currentSpeed = (lb + ub) / 2;
        while (lb < ub) {
            currentSpeed = (lb + ub) / 2;

            int hoursSpent = 0;
            for (int pile: piles) {
                hoursSpent += Math.ceilDiv(pile, currentSpeed);
            }

            // We want to find the speed that is the maximum number less than the target

            // Reduce the search space
            if (hoursSpent <= h) {
                // Decrease the speed
                ub = currentSpeed;
            } else {
                // Increase the speed
                lb = currentSpeed + 1;
            }
        }
        return lb;
    }

    private int minEatingSpeedBruteForce(int[] piles, int h) {
        int currentSpeed = 1;
        while(true) {
            int hoursSpent = 0;
            for (int pile: piles) {
                hoursSpent += Math.ceilDiv(pile, currentSpeed);
            }

            if (hoursSpent <= h) {
                return currentSpeed;
            }

            currentSpeed++;
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        // return minEatingSpeedBruteForce(piles, h);
        return minEatingSpeedOptimized(piles, h);
    }
}
