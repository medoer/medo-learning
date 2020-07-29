package medo.demo.java.thread.pool;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author: bryce
 * @date: 2020-07-25
 */
public class ThreadPoolWithFuture {

    public static void main(String[] args) {
        // get count of available cores
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(availableProcessors);
        Future<Integer> submit = threadPool.submit(() -> {
            Thread.sleep(3_000);
            return new Random().nextInt();
        });
        try {
            Integer integer = submit.get();
            System.out.println(integer);
        } catch (InterruptedException | ExecutionException e1) {
            e1.printStackTrace();
        }
//        for (int i = 0; i < 100; i++) {
//            Future<Integer> submit = threadPool.submit(() -> {
//                return new Random().nextInt();
//            });
//        }
        threadPool.shutdown();
    }
}
