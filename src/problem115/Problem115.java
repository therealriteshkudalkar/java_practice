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

            // Visit the neighbours of the original node
            for (Node neighbour: currentNode.neighbors) {
                if (!visited.contains(neighbour.val)) {
                    visited.add(neighbour.val);
                    queue.add(neighbour);
                }

                Node currentNodeCopy = map.get(currentNode.val);
                Node neighbourCopy = map.getOrDefault(neighbour.val, new Node(neighbour.val));

                // Add the corresponding neighbour to adj list
                currentNodeCopy.neighbors.add(neighbourCopy);

                // Always put the neighbourCopy in the map
                map.putIfAbsent(neighbour.val, neighbourCopy);
            }
        }

        return map.get(node.val);
    }
}
