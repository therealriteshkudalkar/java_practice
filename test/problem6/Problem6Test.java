package problem6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    void changeValuesForAscendingInOrder() {
        Problem6 pb = new Problem6();

        TreeNode resultantTree = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode root = new TreeNode(5, new TreeNode(7), new TreeNode(3));
        pb.changeValuesForAscendingInOrder(root, 0);

        assertEquals(resultantTree.toString(), root.toString());
    }

    @Test
    void changeValuesForAscendingInOrder1() {
        Problem6 pb = new Problem6();

        TreeNode resultantTree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        null));

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(11)),
                new TreeNode(3,
                        new TreeNode(5), null));
        pb.changeValuesForAscendingInOrder(root, 0);

        assertEquals(resultantTree.toString(), root.toString());
    }

    @Test
    void changeValuesForAscendingInOrder2() {
        Problem6 pb = new Problem6();

        TreeNode resultantTree = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(9,
                                new TreeNode(7,
                                        null,
                                        new TreeNode(8)),
                                new TreeNode(10)
                        )));

        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(6),
                        new TreeNode(11)),
                new TreeNode(3,
                        new TreeNode(5),
                        new TreeNode(9,
                                new TreeNode(11,
                                        null,
                                        new TreeNode(13)),
                                new TreeNode(12))));
        pb.changeValuesForAscendingInOrder(root, 0);

        assertEquals(resultantTree.toString(), root.toString());
    }
}