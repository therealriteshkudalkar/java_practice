package problem67;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem67Test {

    @Test
    void findMode() {
        Problem67 problem = new Problem67();

        TreeNode tree1 = new TreeNode(
                1,
                null,
                new TreeNode(
                        2,
                        new TreeNode(2),
                        null
                )
        );
        int[] resultantArray1 = problem.findMode(tree1);
        Arrays.sort(resultantArray1);
        assertArrayEquals(new int[]{2}, resultantArray1);

        TreeNode tree2 = new TreeNode(0);
        int[] resultantArray2 = problem.findMode(tree2);
        Arrays.sort(resultantArray2);
        assertArrayEquals(new int[]{0}, resultantArray2);
    }
}