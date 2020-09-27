package medo.demo.java.basic.jdk8.lambda;

import java.util.function.Function;

public class FunctionAndThen {

    public void andThen() {
        Function<Long, Long> fun1 = number -> number + 1;
        Function<Long, Long> fun2 = number -> number + 1;
        Long r = fun1.andThen(fun2).apply(1L);
        System.out.println(r);
    }

    public static void main(String[] args) {
        new FunctionAndThen().andThen();
    }
}
