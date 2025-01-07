package problem68;

public class Problem68 {
    private TreeNode bstToGstRec(TreeNode root, int greaterThanValue) {
        if (root == null) {
            return null;
        }

        TreeNode currentNode = new TreeNode(root.val);
        if (root.right != null) {
            TreeNode rightSubtree = bstToGst(root.right);
            currentNode.right = rightSubtree;
            currentNode.val += rightSubtree.val;
        }

        if (root.left != null) {
            currentNode.left = bstToGstRec(root.left, currentNode.val);
            //currentNode.val +=
        }
        return currentNode;
    }

    public TreeNode bstToGst(TreeNode root) {
        // Have to start with the right most node and create a tree by traversing up
        // if right node is null i.e. then the resultant node's val is node.val
        // if right node is not null then the resultant node's val is node.val + node.val of right subtree returned by the call

        return bstToGstRec(root, 0);
    }
}
