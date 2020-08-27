package medo.algorithm;

/**
 * 广度优先搜索。
 * 
 * @author bryce
 *
 */
public interface MaxDepthOfBinaryTree {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int run(TreeNode root);

}
