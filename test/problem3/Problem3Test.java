package problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void recoverTree() {
        Problem3 pb = new Problem3();
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        pb.recoverTree(root);
        TreeNode ans = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
        assertEquals(ans.toString(), root.toString());
    }

    @Test
    void recoverTree1() {
        Problem3 pb = new Problem3();
        TreeNode root = new TreeNode();
        pb.recoverTree(root);
        TreeNode ans = new TreeNode();
        assertEquals(ans.toString(), root.toString());
    }
}