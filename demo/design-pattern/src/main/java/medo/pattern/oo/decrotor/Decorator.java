package medo.pattern.oo.decrotor;

import java.util.function.BiConsumer;

/**
 * 统一接口。
 * 
 * @author: bryce
 * @date: 2020-08-16
 */
public interface Decorator extends BiConsumer<Param, DecoratorChain> {

}
