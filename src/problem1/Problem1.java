package problem1;

public class Problem1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Integer.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
