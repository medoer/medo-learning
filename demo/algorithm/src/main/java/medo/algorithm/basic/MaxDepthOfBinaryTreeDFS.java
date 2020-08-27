package medo.algorithm.basic;

import medo.algorithm.MaxDepthOfBinaryTree;

public class MaxDepthOfBinaryTreeDFS implements MaxDepthOfBinaryTree {

    @Override
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int depthLeft = run(root.left);
            int depthRight = run(root.right);
            return Math.max(depthLeft, depthRight) + 1;
        }
    }

}
