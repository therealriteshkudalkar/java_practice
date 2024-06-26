package problem2;

public class Problem2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return root1;
        } else if (root1 == null && root2 != null) {
            return root2;
        } else {
            TreeNode newNode = new TreeNode(root1.val + root2.val);
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
            return newNode;
        }
    }
}
