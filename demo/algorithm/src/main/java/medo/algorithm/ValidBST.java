package medo.algorithm;

/**
 * 98. Valid BST(Binary Search Tree).
 * 
 * @author bryce
 *
 */
public interface ValidBST {

    boolean run(TreeNode root);

    default void validParams(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
