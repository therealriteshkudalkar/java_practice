package problem63;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem63Test {

    @Test
    void hasPathSum() {
        Problem63 problem = new Problem63();

        assertFalse(problem.hasPathSum(null, 0));

        TreeNode tree1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertFalse(problem.hasPathSum(tree1, 5));

        TreeNode tree2 = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                            new TreeNode(7),
                            new TreeNode(2)
                        ),
                        null
                ),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1)
                        )
                )
        );
        assertTrue(problem.hasPathSum(tree2, 22));
    }
}