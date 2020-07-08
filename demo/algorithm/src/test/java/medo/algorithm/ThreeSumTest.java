package medo.algorithm;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.ThreeSum;
import medo.algorithm.basic.ThreeSumIterate;
import medo.algorithm.hash.ThreeSumHashSet;
import medo.algorithm.ohter.ThreeSumTwoPointer;

public class ThreeSumTest {

    @Test
    public void validParams() {
        ThreeSum threeSum = new ThreeSumIterate();
        // nums is null
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            threeSum.run(null);
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            threeSum.run(new int[] { 1, 2 });
        });
    }

    @Test
    public void testBasic() {
        ThreeSum threeSum = new ThreeSumIterate();
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum.run(nums);
        Assert.assertTrue(result.contains(Arrays.asList(-1, 0, 1))
                && result.contains(Arrays.asList(-1, -1, 2)));
        // not found
        List<List<Integer>> result2 = threeSum.run(new int[] {1, 2, 3});
        Assert.assertTrue(result2.isEmpty());
    }

    @Test
    public void testHashSet() {
        ThreeSum threeSum = new ThreeSumHashSet();
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum.run(nums);
        Assert.assertTrue(result.contains(Arrays.asList(-1, 0, 1))
                && result.contains(Arrays.asList(-1, -1, 2)));
        // not found
        List<List<Integer>> result2 = threeSum.run(new int[] {1, 2, 3});
        Assert.assertTrue(result2.isEmpty());
    }
    
    @Test
    public void testTwoPointer() {
        ThreeSum threeSum = new ThreeSumTwoPointer();
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum.run(nums);
        Assert.assertTrue(result.contains(Arrays.asList(-1, 0, 1))
                && result.contains(Arrays.asList(-1, -1, 2)));
        // not found
        List<List<Integer>> result2 = threeSum.run(new int[] {1, 2, 3});
        Assert.assertTrue(result2.isEmpty());
    }

}
