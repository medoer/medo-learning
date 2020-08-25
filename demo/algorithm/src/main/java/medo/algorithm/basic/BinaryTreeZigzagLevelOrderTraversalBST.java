package medo.algorithm.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import medo.algorithm.BinaryTreeZigzagLevelOrderTraversal;

public class BinaryTreeZigzagLevelOrderTraversalBST implements BinaryTreeZigzagLevelOrderTraversal {

    @Override
    public List<List<Integer>> run(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        LinkedList<Integer> list = new LinkedList<>();
        boolean order = false;
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                if (order) {
                    list.addFirst(treeNode.val);
                } else {
                    list.addLast(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            } else {
                result.add(list);
                list = new LinkedList<>();
                if (queue.size() > 0) {
                    queue.add(null);
                    order = !order;
                }
            }
        }
        return result;
    }

}
