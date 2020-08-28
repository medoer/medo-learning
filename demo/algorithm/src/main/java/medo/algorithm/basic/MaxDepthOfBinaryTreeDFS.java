package medo.algorithm.basic;

import medo.algorithm.MaxDepthOfBinaryTree;

public class MaxDepthOfBinaryTreeDFS implements MaxDepthOfBinaryTree {

    @Override
    public int run(TreeNode root) {
        if (root == null) return 0;
        return Math.max(run(root.left), run(root.right)) + 1;
    }

}
