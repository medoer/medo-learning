package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.queue.KthLargestElementByPriorityQueue;

public class KthLargestElementTest {

    @Test
    public void testPriorityQueue() {
        KthLargestElement kthLargestElement = new KthLargestElementByPriorityQueue(3, new int[] { 4, 5, 8, 2 });
        test(kthLargestElement);
    }

    /*
     * k = 3; arr = [4, 5, 8, 2]
     */
    private void test(KthLargestElement kthLargestElement) {
        int run = kthLargestElement.run(3);
        Assert.assertTrue(run == 4);
        int run2 = kthLargestElement.run(5);
        Assert.assertTrue(run2 == 5);
        int run3 = kthLargestElement.run(10);
        Assert.assertTrue(run3 == 5);
        int run4 = kthLargestElement.run(9);
        Assert.assertTrue(run4 == 8);
    }

}
