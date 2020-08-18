package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.basic.AddParrenthessesMinValueBasic;

public class AddParrenthessesMinValueTest {

    @Test
    public void test() {
        AddParrenthessesMinValue addParrenthessesMinValueBasic = new AddParrenthessesMinValueBasic();
        int run = addParrenthessesMinValueBasic.run("1+2+3-3+2");
        Assert.assertTrue(1 == run);
    }

}
