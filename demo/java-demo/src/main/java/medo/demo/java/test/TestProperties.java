package medo.demo.java.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池等配置项。
 * 
 * @author bryce
 *
 */
public class TestProperties {

    private int concurrentNum;

    private int numberOfTests;

    private ExecutorService pool;

    private TestProperties() {
    }

    public static TestProperties build(int curNums, int numberOfTests) {
        TestProperties testProperties = new TestProperties();
        testProperties.setConcurrentNum(curNums);
        testProperties.setNumberOfTests(numberOfTests);
        testProperties.setPool(new ThreadPoolExecutor(numberOfTests,
              numberOfTests,
              0,
              TimeUnit.SECONDS,
              new SynchronousQueue<Runnable>(),
              Executors.defaultThreadFactory(),
              new ThreadPoolExecutor.AbortPolicy()));
        return testProperties;
    }

    public int getConcurrentNum() {
        return concurrentNum;
    }

    public void setConcurrentNum(int concurrentNum) {
        this.concurrentNum = concurrentNum;
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public ExecutorService getPool() {
        return pool;
    }

    public void setPool(ExecutorService pool) {
        this.pool = pool;
    }

}
