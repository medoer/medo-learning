package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.dynamic.MaxDiffArrDP;

public class MaxDiffArrayTest {

    @Test
    public void dpTest() {
        MaxDiffArray maxDiffArray = new MaxDiffArrDP();
        int[] arr = new int[] { -2, -1, 20, 31, 9, 33 };
        int diff = maxDiffArray.run(arr);
        Assert.assertTrue(diff == 35);
    }

}
