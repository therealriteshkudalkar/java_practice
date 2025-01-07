package problem65;

public class Problem65 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // root.val > high then there is no point in visiting the right subtree
        // root.val < low then there is no point in visiting the left subtree

        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if (root.val >= low) {
            // visit the left subtree because you might find the
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val <= high) {
            // visit the right subtree because you might
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
