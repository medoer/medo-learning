package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.BreadthFirstSearch.TreeNode;
import medo.algorithm.basic.BreadthFristSearchImpl;

public class BreadthFirstSearchTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(24);
        root.left.right = new TreeNode(23);
        BreadthFirstSearch breadthFristSearch = new BreadthFristSearchImpl();
        TreeNode run = breadthFristSearch.run(root, 12);
        Assert.assertNull(run);
        Assert.assertNotNull(breadthFristSearch.run(root, 23));
        Assert.assertNotNull(breadthFristSearch.run(root, 21));
        Assert.assertNotNull(breadthFristSearch.run(root, 30));
    }

}
