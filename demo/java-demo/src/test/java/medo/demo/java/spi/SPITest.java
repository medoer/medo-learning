package medo.demo.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.junit.Assert;
import org.junit.Test;

public class SPITest {

    @Test
    public void test() {
        ServiceLoader<People> peoples = ServiceLoader.load(People.class);
        Iterator<People> iterator = peoples.iterator();
        while (iterator.hasNext()) {
            People next = iterator.next();
            Assert.assertNotNull("Chinese".equals(next.speak()));
        }
    }
}
