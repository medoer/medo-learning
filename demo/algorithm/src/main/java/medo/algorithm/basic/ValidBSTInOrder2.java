package medo.algorithm.basic;

import medo.algorithm.ValidBST;

public class ValidBSTInOrder2 implements ValidBST {

    TreeNode prev = null;

    @Override
    public boolean run(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!helper(root.left)) {
            return false;
        }
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return helper(root.right);
    }

}
