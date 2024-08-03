package problem3;

public class Problem3 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val > root.val) {
            int temp = root.left.val;
            root.left.val = root.val;
            root.val = temp;
            recoverTree(root.left);
        }
        if (root.right != null && root.right.val < root.val) {
            int temp = root.right.val;
            root.right.val = root.val;
            root.val = temp;
            recoverTree(root.right);
        }
    }
}
