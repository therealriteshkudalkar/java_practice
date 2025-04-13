package problem65;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem65Test {

    @Test
    void rangeSumBST() {
        Problem65 problem = new Problem65();

        TreeNode tree1 = new TreeNode(
                10,
                new TreeNode(
                        5,
                        new TreeNode(3),
                        new TreeNode(7)
                ),
                new TreeNode(
                        15,
                        null,
                        new TreeNode(18)
                )
        );
        assertEquals(32, problem.rangeSumBST(tree1, 7, 15));
    }
}