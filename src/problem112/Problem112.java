package problem112;

import java.util.ArrayDeque;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

// a -> 2, 0.5 <- b -> 3.0, 0.333 <- c

public class Problem112 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Graph
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.getFirst();
            String denominator = equation.getLast();
            double value = values[i];

            // Form the graph
            graph.computeIfAbsent(numerator, key -> new HashMap<>()).put(denominator, value);
            graph.computeIfAbsent(denominator, key -> new HashMap<>()).put(numerator, 1.0 / value);
        }

        record Pair(String node, double value) {}

        // Loop through the queries and resolve each one of them
        double[] results = new double[queries.size()];
        int index = 0;
        for (List<String> query: queries) {
            String numerator = query.getFirst();
            String denominator = query.getLast();

            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                results[index++] = -1.0;
                continue;
            }

            // Perform a BFS with the numerator as a source vertex until we find the denominator
            Queue<Pair> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            queue.add(new Pair(numerator, 1.0));
            visited.add(numerator);

            int indexVal = index;

            while(!queue.isEmpty()) {
                Pair currentNode = queue.poll();

                // Check if this current node is the
                if (denominator.equals(currentNode.node())) {
                    results[index++] = currentNode.value();
                    break;
                }

                HashMap<String, Double> neighbourMap = graph.get(currentNode.node());
                for(String neighbour: neighbourMap.keySet()) {
                    if (visited.contains(neighbour)) {
                        continue;
                    }

                    // If not visited
                    visited.add(neighbour);
                    queue.add(new Pair(neighbour, currentNode.value() * neighbourMap.get(neighbour)));
                }
            }

            if (indexVal == index) {
                results[index++] = -1.0;
            }
        }
        return results;
    }
}
