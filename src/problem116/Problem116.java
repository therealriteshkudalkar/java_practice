package problem116;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem116 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Create a record of type pair
        record NodeLevel(int node, int level) {}

        // Initialize adjacency list
        List<List<Integer>> adjList = Stream.generate(ArrayList<Integer>::new).limit(n).collect(Collectors.toList());

        // Fill the adjacency list
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        HashMap<Integer, List<Integer>> heightNodeList = new HashMap<>();
        int minHeight = Integer.MAX_VALUE;

        for (int u = 0; u < n; u++) {
            // Treating u as a root, find the height of the tree
            int height = 0;

            Deque<NodeLevel> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n];

            queue.add(new NodeLevel(u, height));
            visited[u] = true;

            while(!queue.isEmpty()) {
                NodeLevel currNode = queue.poll();

                height = Math.max(height, currNode.level);

                // Visit all the adjacent neighbours
                for (int v: adjList.get(currNode.node)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(new NodeLevel(v, currNode.level + 1));
                    }
                }
            }

            heightNodeList.computeIfAbsent(height, key -> new ArrayList<>()).add(u);
            minHeight = Math.min(minHeight, height);
        }
        return heightNodeList.getOrDefault(minHeight, new ArrayList<>());
    }
}
