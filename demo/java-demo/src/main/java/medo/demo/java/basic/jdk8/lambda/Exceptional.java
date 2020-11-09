package medo.demo.java.basic.jdk8.lambda;

import lombok.AllArgsConstructor;

import java.util.function.Function;
import java.util.function.Supplier;

@AllArgsConstructor
public class Exceptional {
    // TODO 查询怎么做判断
//    private Class<FunctionalInterface> functionalInterfaceClass;
    private final Supplier<?> supplier;

    private final Supplier<?> handler;

    public Object orElseGet() {
        try {
            return supplier.get();
        } catch (Throwable e) {
            return handler.get();
        }
    }
}
