package medo.algorithm.basic;

import medo.algorithm.MinDepthOfBinaryTree;

public class MinDepthOfBinaryTreeDFS implements MinDepthOfBinaryTree {

//
    @Override
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
        int depthLeft = run(root.left);
        int depthRight = run(root.right);
        // 1. left == null && right == null 则为叶子节点 return 1;
        // 2. left == null && right != null 或者 left != null && right == null 深度加 1 
        if (root.left == null || root.right == null) {
            return depthLeft + depthRight + 1;
        }
        return Math.min(depthLeft, depthRight) + 1;
    }

}
