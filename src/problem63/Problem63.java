package problem63;

public class Problem63 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        boolean leftPathSum = false;
        if (root.left != null) {
            leftPathSum = hasPathSum(root.left, targetSum - root.val);
        }

        boolean rightPathSum = false;
        if (root.right != null) {
            rightPathSum = hasPathSum(root.right, targetSum - root.val);
        }

        return leftPathSum || rightPathSum;
    }
}
