package problem62;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem62Test {

    @Test
    void levelOrderBottom() {
        Problem62 problem = new Problem62();

        assertEquals(new ArrayList<>(), problem.levelOrderBottom(null));

        TreeNode tree1 = new TreeNode(1);
        assertEquals(List.of(List.of(1)), problem.levelOrderBottom(tree1));

        TreeNode tree2 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assertEquals(List.of(
                List.of(15, 7),
                List.of(9, 20),
                List.of(3)
        ), problem.levelOrderBottom(tree2));
    }
}