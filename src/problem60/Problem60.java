package problem60;

import java.util.*;

public class Problem60 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // NOTE: We need not visit all the trees in the forest
        // Only start DFS for that tree which has the source

        // NOTE: Do not create adjacency list for all the nodes (it is not required)

        // NOTE: If either source or destination is not in the adjacency list that means it is isolated
        // Hence it is impossible to move from source to destination unless they are same

        // Initialize the adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // Form the adjacency list
        for(int[] edge: edges) {
            adjList.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        if (source != destination && (!adjList.containsKey(source) || !adjList.containsKey(destination))) {
            return false;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // Add the source to the queue
        queue.add(source);

        while(!queue.isEmpty()) {
            // Pick the node
            int currentNode = queue.poll();
            visited[currentNode] = true;

            if (currentNode == destination) {
                return true;
            }

            for (int adjacentNode: adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited[adjacentNode]) {
                    queue.add(adjacentNode);
                }
            }
        }

        return false;
    }
}
