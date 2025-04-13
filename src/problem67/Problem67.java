package problem67;

import java.util.*;

public class Problem67 {
    static  class Aggregate {
        int currentNumber;
        int currentNumberFrequency;
        int maxFrequency;
        int[] result;
    }
    private int[] findModeOptimized(TreeNode root, Aggregate aggregate) {
        if (root == null) {
            return new int[]{};
        }

        // Left subtree
        if (root.left != null) {
            int[] newReturnValue = findModeOptimized(root, aggregate);
        }
        // Change the aggregate
        if (root.val == aggregate.currentNumber) {
            aggregate.currentNumberFrequency += 1;
            if (aggregate.currentNumberFrequency > aggregate.maxFrequency) {
                aggregate.maxFrequency = aggregate.currentNumberFrequency;
            }
        } else {
            aggregate.currentNumber = root.val;
            aggregate.currentNumberFrequency = 1;
        }

        return aggregate.result;
    }

    private int[] findModeRec(TreeNode root) {
        // We can use BFS and a hashmap to get the answer
        TreeMap<Integer, Set<TreeNode>> frequencyMap = new TreeMap<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> nodeFrequencyMap = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();

            int currentFrequency = nodeFrequencyMap.getOrDefault(currentNode.val, 0);
            if (frequencyMap.containsKey(currentFrequency)) {
                frequencyMap.get(currentFrequency).remove(currentNode);
            }
            int newFrequency = currentFrequency + 1;
            nodeFrequencyMap.put(currentNode.val, newFrequency);
            frequencyMap.computeIfAbsent(newFrequency, key -> new HashSet<>()).add(currentNode);

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        Set<TreeNode> modeSet = frequencyMap.pollFirstEntry().getValue();
        return modeSet.stream().mapToInt(node -> node.val).toArray();
    }

    public int[] findMode(TreeNode root) {
        // return findModeRec(root);
        return findModeOptimized(root, new Aggregate());
    }
}
