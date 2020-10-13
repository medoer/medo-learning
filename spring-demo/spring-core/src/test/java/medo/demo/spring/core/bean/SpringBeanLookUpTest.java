package medo.demo.spring.core.bean;

import medo.demo.spring.core.bean.dependency.lookup.BeanManagementConfiguration;
import medo.demo.spring.core.bean.dependency.lookup.SuperUser;
import medo.demo.spring.core.bean.dependency.lookup.SuperUserAnnotation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeanManagementConfiguration.class)
public class SpringBeanLookUpTest {

    @Resource
    private ListableBeanFactory beanFactory;

    @Test
    public void testLookupBeanByAnnotation() {
        Map<String, SuperUser>  superUser =  (Map)beanFactory.getBeansWithAnnotation(SuperUserAnnotation.class);
        Assert.assertTrue(superUser.get("superUser") instanceof SuperUser);
    }

}
