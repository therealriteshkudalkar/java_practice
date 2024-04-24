package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void maxDepth1() {
        Problem1 pb = new Problem1();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, null));
        assertEquals(2, pb.maxDepth(root));
    }

    @Test
    void maxDepth2() {
        Problem1 pb = new Problem1();
        TreeNode root1 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        assertEquals(3, pb.maxDepth(root1));
    }
}