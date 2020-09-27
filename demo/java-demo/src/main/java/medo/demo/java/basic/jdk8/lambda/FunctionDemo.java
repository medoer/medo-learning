package medo.demo.java.basic.jdk8.lambda;

import java.util.function.Function;

/**
 * 测试 Function 函数式接口的使用
 */
public class FunctionDemo {

    public Long fun(Function<String, Long> function, String t) {
        return function.apply(t);
    }

    public void fun(ThrowingFunction<Exception> function) throws Exception {
        function.apply();
    }

    public void lambdaRuntimeException(String param) {
        fun((p) -> {
            if ("runtime".equals(param)) {
                throw new RuntimeException("Runtime Exception!");
            }
            return 1L;
        }, param);
    }

    public void throwCheckedException(String param) throws Exception {
        fun(() -> {
            if ("exception".equals(param)) {
                throw new Exception("Exception!");
            }
        });
    }


}
