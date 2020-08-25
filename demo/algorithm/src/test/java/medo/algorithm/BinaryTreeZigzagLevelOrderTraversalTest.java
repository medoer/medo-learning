package medo.algorithm;

import java.util.List;

import org.junit.Test;

import medo.algorithm.BinaryTreeZigzagLevelOrderTraversal.TreeNode;
import medo.algorithm.basic.BinaryTreeZigzagLevelOrderTraversalBST;

public class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void testBST() {
        BinaryTreeZigzagLevelOrderTraversal bst = new BinaryTreeZigzagLevelOrderTraversalBST();
        test(bst);
    }

    public void test(BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> run = binaryTreeZigzagLevelOrderTraversal.run(root);
        System.out.println(run);
    }

}
