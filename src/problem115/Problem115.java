package problem115;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

public class Problem115 {
    public Node cloneGraph(Node node) {
        Deque<Node> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Node> map = new HashMap<>();

        queue.add(node);
        visited.add(node.val);

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            map.putIfAbsent(currentNode.val, new Node(currentNode.val));

            // Visit the neighbors of the original node
            for (Node neighbor: currentNode.neighbors) {
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }

                Node currentNodeCopy = map.get(currentNode.val);
                Node neighborCopy = map.getOrDefault(neighbor.val, new Node(neighbor.val));

                // Add the corresponding neighbor to the adjacency list
                currentNodeCopy.neighbors.add(neighborCopy);

                // Always put the neighbourCopy in the map
                map.putIfAbsent(neighbor.val, neighborCopy);
            }
        }

        return map.get(node.val);
    }
}
