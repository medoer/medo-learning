package medo.demo.java.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class TestSuit {

    TestProperties testProperties;

    public TestSuit(TestProperties testProperties) {
        this.testProperties = testProperties;
    }

    public void excute(BaseTestCase testCase, BaseTestReport testReport) throws InterruptedException {

        if (testCase == null) {
            return;
        }

        BigDecimal val1 = BigDecimal.valueOf(testProperties.getConcurrentNum());
        BigDecimal val2 = BigDecimal.valueOf(testProperties.getNumberOfTests());

        int result = val2.divide(val1, BigDecimal.ROUND_UP).intValue();

        List<Future<BaseResponse>> results = new ArrayList<>();

        // 将请求分批发送
        for (int i = 0; i < result; i++) {
            int size = testProperties.getConcurrentNum();
            if (i + 1 == result) {
                size = testProperties.getNumberOfTests() - (testProperties.getConcurrentNum() * i);
            }

            results.addAll(singleExecution(size, testCase));
        }

        testProperties.getPool().shutdown();

        if (testReport == null) {
            throw new IllegalArgumentException();
        } else {
            testReport.calResult(results);
        }

    }

    private List<Future<BaseResponse>> singleExecution(int size, BaseTestCase testCase) throws InterruptedException {

        List<Callable<BaseResponse>> tasks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tasks.add(testCase);
        }

        return testProperties.getPool().invokeAll(tasks);
    }
}
