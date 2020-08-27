package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.MaxDepthOfBinaryTree.TreeNode;
import medo.algorithm.basic.MaxDepthOfBinaryTreeDFS;

public class MaxDepthOfBinaryTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(24);
        root.left.right = new TreeNode(23);
        root.left.right.right = new TreeNode(23);
        MaxDepthOfBinaryTree mdbt = new MaxDepthOfBinaryTreeDFS();
        int depth = mdbt.run(root);
        Assert.assertEquals(4, depth);
    }

}
