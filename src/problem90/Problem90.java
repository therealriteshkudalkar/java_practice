package problem90;

import java.util.Arrays;

public class Problem90 {
    public int numRescueBoats(int[] people, int limit) {
        // Sort people by weight
        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int boatCount = 0;
        while(i <= j) {
            if (people[i] + people[j] <= limit) {
                // Cross the river
                boatCount++;
                i++;
                j--;
            } else if (people[j] <= limit) {
                // Person with larger weight is sent first
                boatCount++;
                j--;
            } else if (people[i] <= limit) {
                i++;
                boatCount++;
            }
        }
        return boatCount;
    }
}
