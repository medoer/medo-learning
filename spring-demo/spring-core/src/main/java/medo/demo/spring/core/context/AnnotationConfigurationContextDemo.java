package medo.demo.spring.core.context;

import medo.demo.spring.core.bean.dependency.lookup.SuperUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SuperUser.class)
public class AnnotationConfigurationContextDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // register @Configuration
        annotationConfigApplicationContext.register(AnnotationConfigurationContextDemo.class);
        // start application context
        annotationConfigApplicationContext.refresh();
        // the application context was prepared
        // do something
        // close application context, callback the close callback function
        annotationConfigApplicationContext.close();
    }

}
