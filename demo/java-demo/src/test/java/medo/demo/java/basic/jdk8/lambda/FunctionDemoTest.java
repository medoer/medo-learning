package medo.demo.java.basic.jdk8.lambda;


import org.junit.Test;

public class FunctionDemoTest {

    private FunctionDemo functionDemo = new FunctionDemo();

    @Test(expected = RuntimeException.class)
    public void testLambdaRuntimeException() {
        functionDemo.lambdaRuntimeException("runtime");
    }

    @Test(expected = Exception.class)
    public void testLambdaException() throws Exception {
        functionDemo.throwCheckedException("exception");
    }
}
