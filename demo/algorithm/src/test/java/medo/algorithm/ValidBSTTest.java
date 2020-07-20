package medo.algorithm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import medo.algorithm.ValidBST.TreeNode;
import medo.algorithm.basic.ValidBSTInOrder;
import medo.algorithm.basic.ValidBSTInOrder2;
import medo.algorithm.recursion.ValidBSTRecursion;

public class ValidBSTTest {

    @Test
    public void testRecursion() {
        ValidBST validBST = new ValidBSTRecursion();
        test(validBST);
    }

    @Test
    public void testInOrder() {
        ValidBST validBST = new ValidBSTInOrder();
        test(validBST);
    }

    @Test
    public void testInOrder2() {
        ValidBST validBST = new ValidBSTInOrder2();
        test(validBST);
    }

    public void test(ValidBST validBST) {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        boolean run = validBST.run(root);
        assertTrue(run);
        root.left.left = new TreeNode(100);
        assertFalse(validBST.run(root));
    }

}
