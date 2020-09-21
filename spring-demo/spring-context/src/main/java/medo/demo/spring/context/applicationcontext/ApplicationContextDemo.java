package medo.demo.spring.context.applicationcontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 顶层借口是 BeanFactory, ApplicationContext 接口间接继承了 BeanFactory 接口。
 * 
 * @author: bryce
 * @date: 2020-09-21
 */
@Component
public class ApplicationContextDemo {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BeanFactory beanFactory;

    public <T> T getBean(Class<T> clz) {
        return applicationContext.getBean(clz);
    }

    public <T> T getBeanByFactory(Class<T> clz) {
        return beanFactory.getBean(clz);
    }

}
