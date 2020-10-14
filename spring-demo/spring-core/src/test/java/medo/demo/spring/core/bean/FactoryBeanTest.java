package medo.demo.spring.core.bean;

import medo.demo.spring.core.bean.beaninit.FactoryBeanInit;
import medo.demo.spring.core.bean.dependency.lookup.SuperUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FactoryBeanInit.class)
public class FactoryBeanTest {

    @Resource
    private SuperUser superUser;

    @Test
    public void testGetUser() {
        // init by
        Assert.assertNotNull(superUser);
    }

}
