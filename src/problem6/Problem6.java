package problem6;

public class Problem6 {

    public int changeValuesForAscendingInOrder(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            count = changeValuesForAscendingInOrder(root.left, count);
        }
        count++;
        root.val = count;
        if (root.right != null) {
            count = changeValuesForAscendingInOrder(root.right, count);
        }
        return count;
    }

    public int changeValuesForAscendingPreOrder(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        root.val = ++count;
        count = changeValuesForAscendingPreOrder(root.left, count);
        count = changeValuesForAscendingPreOrder(root.right, count);
        return count;
    }

    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
