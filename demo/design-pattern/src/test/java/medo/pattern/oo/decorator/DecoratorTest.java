package medo.pattern.oo.decorator;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import medo.pattern.oo.decrotor.Decorator;
import medo.pattern.oo.decrotor.DecoratorFactory;
import medo.pattern.oo.decrotor.Param;
import medo.pattern.oo.decrotor.TestDecorator;
import medo.pattern.oo.decrotor.TestDecorator2;

public class DecoratorTest {
    
    @Test
    public void testDecorateChainBuilder() {
        List<Decorator> decorators = new LinkedList<>();
        decorators.add(new TestDecorator());
        decorators.add(new TestDecorator2());
        decorators.add((param, decoratorChain) -> {
//            Entity entity = param.getEntity();
            // do something before
            System.out.println("before domain 3");
            decoratorChain.invokeNext(param);
            // do something post
            System.out.println("after domain 3");
        });

        DecoratorFactory decoratorFactory = new DecoratorFactory(decorators);
        Consumer<Param> decoratorDomain = decoratorFactory.decorate((entity) -> {
            // 业务
            System.out.println("Domain Method!");
        });
        // 执行装饰器
        decoratorDomain.accept(new Param());
    }
    
}
