package medo.algorithm;

import java.util.List;

/**
 * 二叉树的锯齿形层次遍历。
 * 
 * @author bryce
 *
 */
public interface BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(Integer val) {
            this.val = val;
        }
    }

    List<List<Integer>> run(TreeNode root);

}
