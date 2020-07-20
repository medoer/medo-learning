package medo.algorithm;

/**
 * 236. Lowest Common Ancestor of a Binary Tree.
 * 
 * @author bryce
 *
 */
public interface LowestCommonAncestor {

    TreeNode run(TreeNode root, TreeNode p, TreeNode q);

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
