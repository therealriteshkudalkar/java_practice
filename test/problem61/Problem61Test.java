package problem61;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem61Test {

    @Test
    void levelOrder() {
        Problem61 problem = new Problem61();

        TreeNode tree1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assertEquals(List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        ), problem.levelOrder(tree1));

        TreeNode tree2 = new TreeNode(1);
        assertEquals(List.of(List.of(1)), problem.levelOrder(tree2));

        assertEquals(new ArrayList<>(), problem.levelOrder(null));
    }
}