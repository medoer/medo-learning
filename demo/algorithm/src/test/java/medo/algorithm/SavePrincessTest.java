package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.basic.SavePrincessBasic;

public class SavePrincessTest {

    @Test
    public void testRecursion() {
        SavePrincessBasic savePrincessBasic = new SavePrincessBasic();
        String run = savePrincessBasic.run("SSSSR");
        Assert.assertTrue("no".equals(run));
        String run2 = savePrincessBasic.run("SSSR");
        Assert.assertTrue("no".equals(run2));
        String run3 = savePrincessBasic.run("SSSRR");
        Assert.assertTrue("no".equals(run3));
        String run4 = savePrincessBasic.run("SLSR");
        Assert.assertTrue("yes".equals(run4));
    }

}
