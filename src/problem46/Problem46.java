package problem46;

public class Problem46 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int numberOfShots = Math.floorDiv(minutesToTest, minutesToDie);
        // First determine how many rounds we can have floor (minutesToTest/minutesToDies)
        // Examples:
        // rounds = 1, buckets = 1, pigs = 0
        // rounds = 1, buckets = 2, pigs = 1 => P1: 1
        // rounds = 1, buckets = 3, pigs = 2 => P1: 1,2 P2: 2,3
        // rounds = 1, buckets = 4, pigs = 2 => P1: 1,2 P2: 2,3
        // rounds = 1, buckets = 5, pigs = 3 => P1: 1,2,3 P2: 2,3,4 P3: 3,4,5
        // rounds = 1, buckets = 6, pigs = 3 => P1: 1,2,3 P2: 2,3,4 P3: 3,4,5
        // rounds = 1, buckets = 7, pigs = 4 => P1: 1,2,3,4 P2: 2,3,4,5 P3: 3,4,5,6 P4: 4,5,6,7
        // rounds = 1, buckets = 8, pigs = 4 => P1: 1,2,3,4 P2: 2,3,4,5 P3: 3,4,5,6 P4: 4,5,6,7
        // rounds = 2, buckets = 1, pigs = 0
        // rounds = 2, buckets = 2, pigs = 1 => R1P1: 1
        // rounds = 2, buckets = 3, pigs = 1 => R1P1: 1 R2P1: 2
        // rounds = 2, buckets = 4, pigs = 2 => R1P1:
        return 0;
    }
}
