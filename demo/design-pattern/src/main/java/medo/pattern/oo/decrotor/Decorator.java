package medo.pattern.oo.decrotor;

import java.util.function.BiConsumer;

/**
 * 统一接口。实现中调用 {@link DecoratorChain#invokeNext(Param)} 方法。
 * 
 * @author: bryce
 * @date: 2020-08-16
 */
public interface Decorator extends BiConsumer<Param, DecoratorChain> {

}
