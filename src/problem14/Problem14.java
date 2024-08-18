package problem14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem14 {
    static class RandomizedSet {
        private final HashMap<Integer, Integer> map;
        private final ArrayList<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            // Add to the val to the list and the map with the index in the list
            int index = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            // Remove from the arraylist and the map
            // Swap the element at the index and the last element
            // Update the index in map for the element with which it was swapped
            int indexOfElementToBeRemoved = map.get(val);
            int itemAtLastIndex = list.get(list.size() - 1);
            map.put(itemAtLastIndex, indexOfElementToBeRemoved);
            map.remove(val);
            list.set(indexOfElementToBeRemoved, itemAtLastIndex);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            // Get the random index using Rand method and get the element
            int index = (int) (Math.random() * list.size());
            return list.get(index);
        }
    }
}
