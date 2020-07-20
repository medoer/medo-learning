package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.LowestCommonAncestor.TreeNode;
import medo.algorithm.recursion.LowestCommonAncestorRecursion;

public class LowestCommonAncestorTest {

    @Test
    public void testRecurion() {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestorRecursion();
        test(lowestCommonAncestor);
    }

    private void test(LowestCommonAncestor lowestCommonAncestor) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(200);
        root.right = new TreeNode(300);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(301);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        TreeNode run = lowestCommonAncestor.run(root, p, q);
        Assert.assertTrue(run == root.left);
        q = root.right;
        TreeNode run2 = lowestCommonAncestor.run(root, p, q);
        Assert.assertTrue(run2 == root);
        p = root;
        TreeNode run3 = lowestCommonAncestor.run(root, p, q);
        Assert.assertTrue(root == run3);
    }
}
