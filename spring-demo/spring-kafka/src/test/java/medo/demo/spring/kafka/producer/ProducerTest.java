package medo.demo.spring.kafka.producer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import medo.demo.spring.kafka.KafkaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class ProducerTest {

    @Autowired
    private Producer producer;

    @Test
    public void testSyncSend() {
        long id = System.currentTimeMillis() / 1000;
        SendResult<?, ?> result;
        try {
            result = producer.syncSend(id, "test");
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 阻塞等待，保证消费
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testASyncSend() throws InterruptedException {
        long id = System.currentTimeMillis() / 1000;
        producer.asyncSend(id, "test").addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {

            @Override
            public void onFailure(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                System.out.println(result.getRecordMetadata());
            }

        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
