package medo.algorithm.basic;

import medo.algorithm.DeepFirstSearch;

public class DeepFristSearchImpl implements DeepFirstSearch {

    @Override
    public TreeNode run(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = run(root.left, val);
        if (left != null) {
            return left;
        } else {
            return run(root.right, val);
        }
    }

}
