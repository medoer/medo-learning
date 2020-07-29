package medo.demo.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread Pool Demo. 线程对象存储在 blocking queue 中，线程池中线程个数建议和机器核心数一致。 如果线程执行 IO
 * 密集型任务，线程池中应该放入更多的线程，在任务阻塞时可以保证还有线程去获取任务。
 * 
 * @author: bryce
 * @date: 2020-07-25
 */
public class ThreadPool {

    public static void main(String[] args) {
        // get count of available cores
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(availableProcessors);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println(33);
                    e.printStackTrace();
                }
                System.out.println("Thread Name: " + Thread.currentThread().getName());
            });
        }
        // 关闭线程池,清理线程池中的线程
        threadPool.shutdown();
        try {
            boolean awaitTermination = threadPool.awaitTermination(300, TimeUnit.SECONDS);
            System.out.println(awaitTermination);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
