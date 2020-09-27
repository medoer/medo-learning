package medo.demo.java.basic.jdk8.lambda;

@FunctionalInterface
public interface ThrowingFunction<E extends Exception> {
    void apply() throws Exception;
}
