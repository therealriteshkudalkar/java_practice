package problem25;

public class Problem25 {

    private boolean prunedNodeRemoved(TreeNode root) {
        if (root.left == null && root.right == null) {
            // Check if the node itself is 1; if yes then return false else return true
            return root.val != 1;
        }
        // Prune left subtree
        boolean removedLeftSubTree = false;
        if (root.left != null) {
            removedLeftSubTree = prunedNodeRemoved(root.left);
            if (removedLeftSubTree) {
                root.left = null;
            }
        }
        // Prune right subtree
        boolean removedRightSubTree = false;
        if (root.right != null) {
            removedRightSubTree = prunedNodeRemoved(root.right);
            if (removedRightSubTree) {
                root.right = null;
            }
        }
        // if both the trees do have 1 in their subtree then return false
        return removedLeftSubTree && removedRightSubTree && root.val != 1;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (prunedNodeRemoved(root)) {
            return null;
        } else {
            return root;
        }
    }
}
