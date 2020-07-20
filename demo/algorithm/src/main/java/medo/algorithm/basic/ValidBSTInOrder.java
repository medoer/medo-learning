package medo.algorithm.basic;

import medo.algorithm.ValidBST;

public class ValidBSTInOrder implements ValidBST {

    private int pre = Integer.MIN_VALUE;

    @Override
    public boolean run(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!run(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return run(root.right);
    }

}
