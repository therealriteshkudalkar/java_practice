package problem12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem12 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        // Since the intervals are not sorted, we have to sort the intervals
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int nonOverLappingIntervalsIndex = 0;
        List<int[]> nonOverLappingIntervals = new ArrayList<>();
        nonOverLappingIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = nonOverLappingIntervals.get(nonOverLappingIntervalsIndex);
            int[] currenInterval = intervals[i];
            // check if the current interval's
            // the previous interval's end is greater than current interval's env
            if (previousInterval[1] >= currenInterval[0]) {
                // Yes it's an over lapping interval so now check which one is max
                previousInterval[1] = Integer.max(previousInterval[1], currenInterval[1]);
            } else {
                // It's not an over lapping interval so just add this new interval to the array
                nonOverLappingIntervalsIndex++;
                nonOverLappingIntervals.add(currenInterval);
            }
        }
        int[][] finalNonOverLappingIntervals = new int[nonOverLappingIntervals.size()][2];
        for (int i  = 0; i < nonOverLappingIntervals.size(); i++){
            finalNonOverLappingIntervals[i] = nonOverLappingIntervals.get(i);
        }
        return finalNonOverLappingIntervals;
    }
}
