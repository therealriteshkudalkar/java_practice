package problem111;

import java.util.Comparator;
import java.util.TreeMap;

// 1, 2, 3, 4, 5, 6, 7, 8
// n = 8
// k = 2
// #w = 4

public class Problem111 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // Stores the max numbers
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        // Stores the min numbers
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Comparator.reverseOrder());
        double[] medians = new double[nums.length - k + 1];
        int index = 0, minHeapSize = 0, maxHeapSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minHeapSize + maxHeapSize == k) {
                // Calculate the median from the minHeap & maxHeap
                medians[index++] = k % 2 == 0 ? ((double) minHeap.firstKey() + maxHeap.firstKey()) / 2 : minHeap.firstKey();

                // Remove the old number from the window
                int keyToBeRemoved = nums[i - k + 1];
                if (minHeap.containsKey(keyToBeRemoved)) {
                    if (minHeap.get(keyToBeRemoved) - 1 == 0) {
                        minHeap.remove(keyToBeRemoved);
                    } else {
                        minHeap.put(keyToBeRemoved, minHeap.get(keyToBeRemoved) - 1);
                    }
                    minHeapSize--;
                } else if (maxHeap.containsKey(keyToBeRemoved)) {
                    if (maxHeap.get(keyToBeRemoved) - 1 == 0) {
                        maxHeap.remove(keyToBeRemoved);
                    } else {
                        maxHeap.put(keyToBeRemoved, maxHeap.get(keyToBeRemoved) - 1);
                    }
                    maxHeapSize--;
                }

                // Rebalance the heaps
                if (k % 2 == 0) {
                    // Both heaps should have the same size (in this case minHeap will have one more element)
                    if (minHeapSize == maxHeapSize) {
                        // Remove the item from maxHeap and put it in minHeap
                        int itemToBeMoved = maxHeap.firstKey();
                        if (maxHeap.get(itemToBeMoved) - 1 == 0) {
                            maxHeap.remove(itemToBeMoved);
                        } else {
                            maxHeap.put(itemToBeMoved, maxHeap.getOrDefault(itemToBeMoved, 0) - 1);
                        }
                        maxHeapSize--;
                        minHeap.put(itemToBeMoved, minHeap.getOrDefault(itemToBeMoved, 0) + 1);
                        minHeapSize++;
                    }
                } else {
                    // minHeap should have size one greater than maxHeap (in this case both will have same size)
                    if (minHeapSize > maxHeapSize) {
                        // Remove the item from minHeap and put it in maxHeap
                        int itemToBeMoved = minHeap.firstKey();
                        if (minHeap.get(itemToBeMoved) - 1 == 0) {
                            minHeap.remove(itemToBeMoved);
                        } else {
                            minHeap.put(itemToBeMoved, minHeap.getOrDefault(itemToBeMoved, 0) - 1);
                        }
                        minHeapSize--;
                        maxHeap.put(itemToBeMoved, maxHeap.getOrDefault(itemToBeMoved, 0) + 1);
                        maxHeapSize++;
                    }
                }
            }

            // Add the new number in the window and rebalance the heaps if required
            minHeap.put(nums[i], minHeap.getOrDefault(nums[i], 0) + 1);
            minHeapSize++;

            // Rebalance the heap
            if (k % 2 == 0) {
                // Both heaps should have the same size
                if (minHeapSize > maxHeapSize) {
                    // Move item from minHeap to maxHeap
                    int itemToBeMoved = minHeap.firstKey();
                    if (minHeap.get(itemToBeMoved) - 1 == 0) {
                        minHeap.remove(itemToBeMoved);
                    } else {
                        minHeap.put(itemToBeMoved, minHeap.getOrDefault(itemToBeMoved, 0) - 1);
                    }
                    minHeapSize--;
                    maxHeap.put(itemToBeMoved, maxHeap.getOrDefault(itemToBeMoved, 0) + 1);
                    maxHeapSize++;
                }
            } else {
                // minHeap should have size one greater than the maxHeap
                if (minHeapSize == maxHeapSize) {
                    // Move item from maxHeap to minHeap
                    int itemToBeMoved = maxHeap.firstKey();
                    if (maxHeap.get(itemToBeMoved) - 1 == 0) {
                        maxHeap.remove(itemToBeMoved);
                    } else {
                        maxHeap.put(itemToBeMoved, maxHeap.getOrDefault(itemToBeMoved, 0) - 1);
                    }
                    maxHeapSize--;
                    minHeap.put(itemToBeMoved, minHeap.getOrDefault(itemToBeMoved, 0) + 1);
                    minHeapSize++;
                } else if (minHeapSize - maxHeapSize > 1) {
                    // Move item from minHeap to maxHeap
                    int itemToBeMoved = minHeap.firstKey();
                    if (minHeap.get(itemToBeMoved) - 1 == 0) {
                        minHeap.remove(itemToBeMoved);
                    } else {
                        minHeap.put(itemToBeMoved, minHeap.getOrDefault(itemToBeMoved, 0) - 1);
                    }
                    minHeapSize--;
                    maxHeap.put(itemToBeMoved, maxHeap.getOrDefault(itemToBeMoved, 0) + 1);
                    maxHeapSize++;
                }
            }

        }
        if (minHeapSize + maxHeapSize == k) {
            medians[index] = k % 2 == 0 ? ((double) minHeap.firstKey() + maxHeap.firstKey()) / 2 : minHeap.firstKey();
        }
        return medians;
    }
}
