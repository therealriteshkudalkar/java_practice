package problem62;

import java.util.*;

public class Problem62 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        record Pair(int level, TreeNode node) {}

        HashMap<Integer, List<Integer>> levelMap = new HashMap<>();

        int maxLevel = 0;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));

        while(!queue.isEmpty()) {
            Pair currentNodeInfo = queue.poll();

            levelMap.computeIfAbsent(currentNodeInfo.level, key -> new ArrayList<>()).add(currentNodeInfo.node.val);

            if (currentNodeInfo.level > maxLevel) {
                maxLevel = currentNodeInfo.level;
            }

            if (currentNodeInfo.node.left != null) {
                queue.add(new Pair(currentNodeInfo.level + 1, currentNodeInfo.node.left));
            }
            if (currentNodeInfo.node.right != null) {
                queue.add(new Pair(currentNodeInfo.level + 1, currentNodeInfo.node.right));
            }
        }

        List<List<Integer>> levelOrderList = new ArrayList<>();
        for(int i = maxLevel; i >= 0; i--) {
            levelOrderList.add(levelMap.get(i));
        }
        return levelOrderList;
    }
}
