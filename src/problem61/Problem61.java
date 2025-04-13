package problem61;

import java.util.*;

public class Problem61 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        record Pair(int level, TreeNode node){}
        HashMap<Integer, List<Integer>> levelMap = new HashMap<>();

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        while(!queue.isEmpty()) {
            Pair currentNode = queue.poll();
            TreeNode currentTreeNode = currentNode.node;

            levelMap.computeIfAbsent(currentNode.level, key -> new ArrayList<>()).add(currentTreeNode.val);

            if (currentTreeNode.left != null) {
                queue.add(new Pair(currentNode.level + 1, currentTreeNode.left));
            }
            if (currentTreeNode.right != null) {
                queue.add(new Pair(currentNode.level + 1, currentTreeNode.right));
            }
        }

        List<List<Integer>> levelOrderList = new ArrayList<>();
        for (int i = 0; ; i++) {
            if (!levelMap.containsKey(i)) {
                break;
            }
            levelOrderList.add(levelMap.get(i));
        }
        return levelOrderList;
    }
}
