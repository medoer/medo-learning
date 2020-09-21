package medo.demo.spring.context;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import medo.demo.spring.context.applicationcontext.ApplicationContextDemo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationContextTest {

    @Autowired
    private ApplicationContextDemo applicationContextDemo;

    @Test
    public void testGetBean() {
        ApplicationContextDemo applicationContext = applicationContextDemo.getBean(ApplicationContextDemo.class);
        Assert.assertNotNull(applicationContext);
    }

    @Test
    public void testGetBeanByFactory() {
        ApplicationContextDemo applicationContext = applicationContextDemo
                .getBeanByFactory(ApplicationContextDemo.class);
        Assert.assertNotNull(applicationContext);
    }

}
