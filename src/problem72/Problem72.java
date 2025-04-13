package problem72;

import java.util.*;

public class Problem72 {

    public String frequencySortOptimized(String s) {
        record Pair(char character, int frequency){}
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.frequency, o2.frequency));
        for (var entry: map.entrySet()) {
            priorityQueue.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder builder = new StringBuilder();
        while(!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            builder.append(String.valueOf(pair.character).repeat(Math.max(0, pair.frequency)));
        }
        return builder.toString();
    }

    public String frequencySort(String s) {
        // TreeMap
        HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();
        TreeMap<Integer, Set<Character>> frequencyCharacterMap = new TreeMap<>(Comparator.reverseOrder());
        for (char c: s.toCharArray()) {
            if (characterFrequencyMap.containsKey(c)) {
                int charFrequency = characterFrequencyMap.get(c);
                int newCharFrequency = charFrequency + 1;
                characterFrequencyMap.put(c, newCharFrequency);
                // Remove from the character from this frequency and add it to new
                frequencyCharacterMap.computeIfPresent(charFrequency, (key, set) -> {
                    set.remove(c);
                    return set;
                });
                frequencyCharacterMap.computeIfAbsent(newCharFrequency, key -> new HashSet<>()).add(c);
            } else {
                characterFrequencyMap.put(c, 1);
                frequencyCharacterMap.computeIfAbsent(1, key -> new HashSet<>()).add(c);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (var entry: frequencyCharacterMap.entrySet()) {
            for (char c: entry.getValue()) {
                builder.append(String.valueOf(c).repeat(Math.max(0, entry.getKey())));
            }
        }
        return builder.toString();
    }
}
