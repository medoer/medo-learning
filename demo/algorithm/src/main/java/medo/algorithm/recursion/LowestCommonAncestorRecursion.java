package medo.algorithm.recursion;

import medo.algorithm.LowestCommonAncestor;

public class LowestCommonAncestorRecursion implements LowestCommonAncestor {

    @Override
    public TreeNode run(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = run(root.left, p, q);
        TreeNode right = run(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
