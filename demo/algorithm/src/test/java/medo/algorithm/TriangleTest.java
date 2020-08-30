package medo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.dynamic.ClimbingStairsDP;
import medo.algorithm.dynamic.ClimbingStairsDP2;
import medo.algorithm.dynamic.TriangleDP;

public class TriangleTest {

    @Test
    public void testDynamic() {
        TriangleDP triangleDP = new TriangleDP();
        test(triangleDP);
    }

    public void test(TriangleDP triangleDP) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(Arrays.asList(2));
        arrayList.add(Arrays.asList(3, 4));
        arrayList.add(Arrays.asList(6, 5, 7));
        arrayList.add(Arrays.asList(4, 1, 8, 3));
        List<List<Integer>> triangle = arrayList;
        Assert.assertEquals(11, triangleDP.run(triangle));
    }

}
