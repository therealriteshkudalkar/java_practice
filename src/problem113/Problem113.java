package problem113;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem113 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Declare inDegree array
        int[] inDegree = new int[numCourses];

        // Declare adjacency List
        List<List<Integer>> adjList = Stream.generate(ArrayList<Integer>::new).limit(numCourses).collect(Collectors.toList());

        // Fill the inDegree array
        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        // Find all nodes with in-degree zero and add them to the queue
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> nodesWithIndegreeZero = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform BFS
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            nodesWithIndegreeZero.add(currNode);

            for (int v: adjList.get(currNode)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Go through the inDegree array and check
        return nodesWithIndegreeZero.size() == numCourses;
    }
}
