package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void mergeTrees() {
        Problem2 pb = new Problem2();
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode merged = new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)));
        assertEquals(merged.toString(), pb.mergeTrees(root1, root2).toString());
    }

    @Test
    void mergeTrees1() {
        Problem2 pb = new Problem2();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode merged = new TreeNode(2, new TreeNode(2), null);
        assertEquals(merged.toString(), pb.mergeTrees(root1, root2).toString());
    }
}