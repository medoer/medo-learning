package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.MinDepthOfBinaryTree.TreeNode;
import medo.algorithm.basic.MinDepthOfBinaryTreeDFS;

public class MinDepthOfBinaryTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(24);
        root.left.right = new TreeNode(23);
        root.left.right.right = new TreeNode(23);
        MinDepthOfBinaryTree mdbt = new MinDepthOfBinaryTreeDFS();
        int depth = mdbt.run(root);
        Assert.assertEquals(2, depth);
    }

}
