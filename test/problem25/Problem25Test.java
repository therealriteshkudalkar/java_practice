package problem25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem25Test {

    @Test
    void pruneTree() {
        Problem25 pb = new Problem25();

        // Test 1
        TreeNode root1 = new TreeNode(
                1,
                null,
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(1)
                )
        );
        TreeNode finalTree1 = new TreeNode(
                1,
                null,
                new TreeNode(
                        0,
                        null,
                        new TreeNode(1)
                )
        );
        assertEquals(finalTree1.toString(), pb.pruneTree(root1).toString());

        // Test 2
        TreeNode root2 = new TreeNode(
                1,
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(0)
                ),
                new TreeNode(
                        1,
                        new TreeNode(0),
                        new TreeNode(1)
                )
        );
        TreeNode finalTree2 = new TreeNode(
                1,
                null,
                new TreeNode(
                        1,
                        null,
                        new TreeNode(1)
                )
        );
        assertEquals(finalTree2.toString(), pb.pruneTree(root2).toString());

        // Test 3
        TreeNode root3 = new TreeNode(
                1,
                new TreeNode(
                        1,
                        new TreeNode(
                                1,
                                new TreeNode(0),
                                null),
                        new TreeNode(1)
                ),
                new TreeNode(
                        0,
                        new TreeNode(0),
                        new TreeNode(1)
                )
        );
        TreeNode finalTree3 = new TreeNode(
                1,
                new TreeNode(
                        1,
                        new TreeNode(1),
                        new TreeNode(1)
                ),
                new TreeNode(
                        0,
                        null,
                        new TreeNode(1)
                )
        );
        assertEquals(finalTree3.toString(), pb.pruneTree(root3).toString());

        // Test 4
        TreeNode root4 = new TreeNode();
        TreeNode finalTree4 = new TreeNode();
        assertEquals(finalTree4.toString(), pb.pruneTree(root4).toString());
    }
}