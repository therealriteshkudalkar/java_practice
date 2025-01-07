package problem66;

public class Problem66 {

    static class WrapperInteger {
        int value;

        WrapperInteger(int val) {
            this.value = val;
        }
    }

    private int getMinimumUsingPassByReference(TreeNode root, WrapperInteger inorderPredecessor) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int minimumDifference = Integer.MAX_VALUE;
        if (root.left != null) {
            minimumDifference = Math.min(minimumDifference, getMinimumUsingPassByReference(root.left, inorderPredecessor));
        }
        if (inorderPredecessor.value != -1) {
            minimumDifference = Math.min(minimumDifference, Math.abs(inorderPredecessor.value - root.val));
        }
        inorderPredecessor.value = root.val;
        if (root.right != null) {
            minimumDifference = Math.min(minimumDifference, getMinimumUsingPassByReference(root.right, inorderPredecessor));
        }
        return minimumDifference;
    }

    public int getMinimumDifference(TreeNode root) {
        return getMinimumUsingPassByReference(root, new WrapperInteger(-1));
    }
}
