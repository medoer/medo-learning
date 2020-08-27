package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.DeepFirstSearch.TreeNode;
import medo.algorithm.basic.DeepFristSearchImpl;

public class DeepFirstSearchTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(24);
        root.left.right = new TreeNode(23);
        DeepFirstSearch dfs = new DeepFristSearchImpl();
        TreeNode run = dfs.run(root, 12);
        Assert.assertNull(run);
        Assert.assertNotNull(dfs.run(root, 23));
        Assert.assertNotNull(dfs.run(root, 21));
        Assert.assertNotNull(dfs.run(root, 30));
    }

}
