package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.search.BinarySearchRecursion;

public class ArraySearchTest {

    @Test
    public void testSearch() {
        ArraySearch bs = new BinarySearchRecursion();
        int[] datas = new int[] {2, 4, 19, 20, 0, 90};
        int res1 = bs.run(datas, 91);
        Assert.assertTrue(res1 == -1);
        int res2 = bs.run(datas, 2);
        Assert.assertTrue(res2 == 1);
    }
}
