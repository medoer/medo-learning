package medo.algorithm;

import medo.algorithm.basic.LongestCommonPrefixImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: yangcj
 * @Date: 2020/11/19 13:15
 */
public class LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefixImpl();
        String[] strs = new String[] {"8sss9", "8sss1"};
        String longestCommonPrefix1 = longestCommonPrefix.longestCommonPrefix(strs);
        Assert.assertEquals(longestCommonPrefix1, "8sss");
    }

}
