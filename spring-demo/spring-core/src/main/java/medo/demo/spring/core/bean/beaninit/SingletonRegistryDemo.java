package medo.demo.spring.core.bean.beaninit;

import medo.demo.spring.core.bean.dependency.lookup.User;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonRegistryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 将手动实力化的 bean 交由 spring 容器管理，区别脱离 ioc 手动控制
        User user = new User();
        ConfigurableListableBeanFactory configurableListableBeanFactory = annotationConfigApplicationContext.getBeanFactory();
        configurableListableBeanFactory.registerSingleton("singletonUser", user);
        annotationConfigApplicationContext.refresh();
        User uu = annotationConfigApplicationContext.getBean("singletonUser", User.class);
        System.out.println(uu);
        annotationConfigApplicationContext.close();
    }

}
