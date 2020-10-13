package medo.demo.spring.core.bean.dependency.lookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanManagementConfiguration {

    @Bean
    public SuperUser superUser() {
        return new SuperUser();
    }
}
