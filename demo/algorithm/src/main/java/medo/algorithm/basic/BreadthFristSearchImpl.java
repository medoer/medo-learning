package medo.algorithm.basic;

import java.util.LinkedList;
import java.util.Queue;

import medo.algorithm.BreadthFirstSearch;

public class BreadthFristSearchImpl implements BreadthFirstSearch {

    @Override
    public TreeNode run(TreeNode root, int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return null;
    }

}
