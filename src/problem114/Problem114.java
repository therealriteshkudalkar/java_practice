package problem114;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem114 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an in-degree array
        int[] inDegree = new int[numCourses];

        // Create adjacency list
        List<List<Integer>> adjList = Stream.generate(ArrayList<Integer>::new).limit(numCourses).collect(Collectors.toList());

        // Fill the adjacency list and in-degree array
        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // Find the
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform BFS
        Set<Integer> nodesHavingZeroInDegree = new LinkedHashSet<>();
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            nodesHavingZeroInDegree.add(currNode);

            for (int v: adjList.get(currNode)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (nodesHavingZeroInDegree.size() != numCourses) {
            return new int[0];
        } else {
            return nodesHavingZeroInDegree.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
