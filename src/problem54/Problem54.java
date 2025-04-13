package problem54;

import java.util.HashMap;
import java.util.TreeMap;

public class Problem54 {
    private int oddEvenJumpsTabulated(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        boolean[] odd = new boolean[arr.length];
        boolean[] even = new boolean[arr.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        odd[arr.length - 1] = true;
        even[arr.length - 1] = true;
        map.put(arr[arr.length - 1], arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (map.containsKey(arr[i])) {
                odd[i] = even[map.get(arr[i])];
                even[i] = odd[map.get(arr[i])];
            } else {
                Integer lowestForEven = map.lowerKey(arr[i]);
                Integer highestForOdd = map.higherKey(arr[i]);

                if (lowestForEven != null) {
                    even[i] = odd[map.get(lowestForEven)];
                }
                if (highestForOdd != null) {
                    odd[i] = even[map.get(highestForOdd)];
                }
            }
            map.put(arr[i], i);
        }

        int count = 0;
        for (boolean oddStartForIndex: odd) {
            if (oddStartForIndex) {
                count++;
            }
        }
        return count;
    }

    private boolean oddEvenJumpsMemoized(HashMap<String, Boolean> memo, int[] arr, int startingIndex, boolean isEvenJump) {
        String key = String.format("%d,%b", startingIndex, isEvenJump);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (startingIndex == arr.length - 1) {
            memo.put(key, true);
            return true;
        }

        int currNum = arr[startingIndex];

        if (isEvenJump) {
            // Loop through the remaining indices to find the index of a number equal to or less than the given number and jump to that index
            int largestNumberIndex = -1;
            for (int i = startingIndex + 1; i < arr.length; i++) {
                int num = arr[i];
                if (num == currNum) {
                    largestNumberIndex = i;
                    break;
                } else if (num < currNum) {
                    if (largestNumberIndex == -1) {
                        largestNumberIndex = i;
                    } else {
                        if (arr[largestNumberIndex] < num) {
                            largestNumberIndex = i;
                        }
                    }
                }
            }

            // If there is no number larger than return false
            if (largestNumberIndex == -1) {
                memo.put(key, false);
                return false;
            }
            boolean returnValue = oddEvenJumpsMemoized(memo, arr, largestNumberIndex, false);
            memo.put(key, returnValue);
            return returnValue;
        } else {
            // Loop through the remaining indices to find the index of a number equal to or greater than the given number and jump to that index
            int smallestNumberIndex = -1;
            for (int i = startingIndex + 1; i < arr.length; i++) {
                int num = arr[i];
                if (num == currNum) {
                    smallestNumberIndex = i;
                    break;
                } else if (num > currNum) {
                    if (smallestNumberIndex == -1) {
                        smallestNumberIndex = i;
                    } else {
                        if (arr[smallestNumberIndex] > num) {
                            smallestNumberIndex = i;
                        }
                    }
                }
            }

            // If there is no number larger than return false
            if (smallestNumberIndex == -1) {
                memo.put(key, false);
                return false;
            }
            boolean returnValue = oddEvenJumpsMemoized(memo, arr, smallestNumberIndex, true);
            memo.put(key, returnValue);
            return returnValue;
        }
    }

    private boolean oddEvenJumpsRec(int[] arr, int startingIndex, boolean isEvenJump) {
        if (startingIndex == arr.length - 1) {
            return true;
        }

        int currNum = arr[startingIndex];

        if (isEvenJump) {
            // Loop through the remaining indices to find the index of a number equal to or less than the given number and jump to that index
            int largestNumberIndex = -1;
            for (int i = startingIndex + 1; i < arr.length; i++) {
                int num = arr[i];
                if (num == currNum) {
                    largestNumberIndex = i;
                    break;
                } else if (num < currNum) {
                    if (largestNumberIndex == -1) {
                        largestNumberIndex = i;
                    } else {
                        if (arr[largestNumberIndex] < num) {
                            largestNumberIndex = i;
                        }
                    }
                }
            }

            // If there is no number larger than return false
            if (largestNumberIndex == -1) {
                return false;
            }

            return oddEvenJumpsRec(arr, largestNumberIndex, false);
        } else {
            // Loop through the remaining indices to find the index of a number equal to or greater than the given number and jump to that index
            int smallestNumberIndex = -1;
            for (int i = startingIndex + 1; i < arr.length; i++) {
                int num = arr[i];
                if (num == currNum) {
                    smallestNumberIndex = i;
                    break;
                } else if (num > currNum) {
                    if (smallestNumberIndex == -1) {
                        smallestNumberIndex = i;
                    } else {
                        if (arr[smallestNumberIndex] > num) {
                            smallestNumberIndex = i;
                        }
                    }
                }
            }

            // If there is no number larger than return false
            if (smallestNumberIndex == -1) {
                return false;
            }
            return oddEvenJumpsRec(arr, smallestNumberIndex, true);
        }
    }

    public int oddEvenJumps(int[] arr) {
        // During odd numbered jumps only jump from i to j if number at i is equal to or one greater than at j
        // During even numbered jumps only jump from i to j if number at i is equal to or one less than at j

        return oddEvenJumpsTabulated(arr);

//        int sum = 0;
//        HashMap<String, Boolean> memo = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            // sum += oddEvenJumpsRec(arr, i, false) ? 1 : 0;
//            sum += oddEvenJumpsMemoized(memo, arr, i, false) ? 1 : 0;
//        }
//        return sum;
    }
}
