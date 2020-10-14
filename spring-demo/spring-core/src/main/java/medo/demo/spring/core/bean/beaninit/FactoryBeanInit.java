package medo.demo.spring.core.bean.beaninit;

import medo.demo.spring.core.bean.dependency.lookup.SuperUser;
import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanInit implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new SuperUser();
    }

    @Override
    public Class<?> getObjectType() {
        return SuperUser.class;
    }

}
