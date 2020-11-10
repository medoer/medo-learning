package medo.demo.java.core;

import medo.demo.java.core.other.RemoveDuplicates;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangcj
 * @Date: 2020/11/10 22:25
 */
public class RemoveDuplicatesTest {

    @Test
    public void testIsRepeat() {
        RemoveDuplicates.Domain domain = new RemoveDuplicates.Domain();
        domain.setName("ihfvf");
        RemoveDuplicates.Domain domain1 = new RemoveDuplicates.Domain();
        domain1.setName("ihfvf");
        RemoveDuplicates.Domain domain2 = new RemoveDuplicates.Domain();
        domain2.setName("ihfg");
        List<RemoveDuplicates.Domain> domains = Arrays.asList(domain, domain1, domain2);
        boolean repeat = new RemoveDuplicates().isRepeat(domains);
        Assert.assertTrue(repeat);
    }

}
