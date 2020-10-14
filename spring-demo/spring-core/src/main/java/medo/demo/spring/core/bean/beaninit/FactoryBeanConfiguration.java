package medo.demo.spring.core.bean.beaninit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfiguration {

    @Bean
    public FactoryBeanInit factoryBeanInit() {
        return new FactoryBeanInit();
    }

}
