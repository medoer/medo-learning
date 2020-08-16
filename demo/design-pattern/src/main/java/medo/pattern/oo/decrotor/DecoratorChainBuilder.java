package medo.pattern.oo.decrotor;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Decorator Chain 构造器。
 * 
 * @author: bryce
 * @date: 2020-08-16
 */
public class DecoratorChainBuilder {

    private List<Decorator> domains = new LinkedList<>();

    public static DecoratorChainBuilder startingWith(Decorator decorator) {
        DecoratorChainBuilder b = new DecoratorChainBuilder();
        b.add(decorator);
        return b;
    }

    private void add(Decorator decorator) {
        this.domains.add(decorator);
    }

    public DecoratorChainBuilder andThen(Decorator decorator) {
        this.add(decorator);
        return this;
    }

    public DecoratorChain andFinally(Consumer<Param> consumer) {
        return buildChain(domains, consumer);
    }

    private DecoratorChain buildChain(List<Decorator> handlers,
            Consumer<Param> consumer) {
        if (handlers.isEmpty()) {
            return consumer::accept;
        } else {
            Decorator head = handlers.get(0);
            List<Decorator> tail = handlers.subList(1, handlers.size());
            return subscriberIdAndMessage -> head.accept(subscriberIdAndMessage, buildChain(tail, consumer));
        }
    }
}
