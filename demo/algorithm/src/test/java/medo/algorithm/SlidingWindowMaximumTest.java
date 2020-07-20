package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.queue.SlidingWindowMaximumWithQueue;

public class SlidingWindowMaximumTest {

    @Test
    public void testQueue() {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximumWithQueue();
        test(slidingWindowMaximum);
    }

    private void test(SlidingWindowMaximum slidingWindowMaximum) {
        int k = 3;
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] run = slidingWindowMaximum.run(k, nums);
        int[] expecteds = new int[] { 3, 3, 5, 5, 6, 7 };
        Assert.assertArrayEquals(expecteds, run);
        k = 1;
        int[] run2 = slidingWindowMaximum.run(k, nums);
        int[] expecteds2 = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        Assert.assertArrayEquals(expecteds2, run2);
        k = 3;
        int[] nums2 = new int[] { 1, 3, 1, 2, 0, 5 };
        int[] expecteds3 = new int[] { 3, 3, 2, 5 };
        int[] run3 = slidingWindowMaximum.run(k, nums2);
        Assert.assertArrayEquals(expecteds3, run3);
    }

}
