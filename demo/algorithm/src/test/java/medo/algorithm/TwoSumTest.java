package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.TwoSum;
import medo.algorithm.basic.TwoSumIterate;
import medo.algorithm.hash.TwoSumHashMap;

public class TwoSumTest {

    @Test
    public void validParams() {
        TwoSum twoSum = new TwoSumIterate();
//        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        // nums is null
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            twoSum.run(null, target);
        });
        // nums is empty
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            twoSum.run(new int[] {}, target);
        });
    }

    @Test
    public void testBasic() {
        TwoSum twoSum = new TwoSumIterate();
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum.run(nums, target);
        Assert.assertArrayEquals(new int[] { 0, 1 }, result);
        // not found
        target = 20;
        int[] result2 = twoSum.run(nums, target);
        Assert.assertArrayEquals(new int[] {}, result2);
    }

    @Test
    public void testHashMap() {
        TwoSum twoSum = new TwoSumHashMap();
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum.run(nums, target);
        Assert.assertArrayEquals(new int[] { 1, 0 }, result);
        // not found
        target = 20;
        int[] result2 = twoSum.run(nums, target);
        Assert.assertArrayEquals(new int[] {}, result2);
    }

}
