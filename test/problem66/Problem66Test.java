package problem66;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem66Test {

    @Test
    void getMinimumDifference() {
        Problem66 problem66 = new Problem66();

        TreeNode tree1 = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(6)
        );
        assertEquals(1, problem66.getMinimumDifference(tree1));

        TreeNode tree2 = new TreeNode(
                1,
                new TreeNode(0),
                new TreeNode(
                        48,
                        new TreeNode(12),
                        new TreeNode(49)
                )
        );
        assertEquals(1, problem66.getMinimumDifference(tree2));

        TreeNode tree3 = new TreeNode(
                236,
                new TreeNode(
                        104,
                        null,
                        new TreeNode(227)
                ),
                new TreeNode(
                        701,
                        null,
                        new TreeNode(911)
                )
        );
        assertEquals(9, problem66.getMinimumDifference(tree3));
    }
}