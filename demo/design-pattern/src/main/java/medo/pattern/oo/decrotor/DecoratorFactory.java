package medo.pattern.oo.decrotor;

import java.util.List;
import java.util.function.Consumer;

/**
 * 装饰器工厂。
 * 
 * @author: bryce
 * @date: 2020-08-16
 */
public class DecoratorFactory {

    private List<Decorator> decorators;

    public DecoratorFactory(List<Decorator> decorators) {
        this.decorators = decorators;
    }

    public Consumer<Param> decorate(Domain domain) {
        DecoratorChainBuilder builder = DecoratorChainBuilder.startingWith(decorators.get(0));
        for (Decorator decorator : decorators.subList(1, decorators.size())) {
            builder = builder.andThen(decorator);
        }

        DecoratorChain chain = builder.andFinally((param) -> {
            Entity entity = param.getEntity();
            try {
                domain.accept(entity);
            } catch (Exception e) {
                throw e;
            }
        });
        return chain::invokeNext;
    }
}
