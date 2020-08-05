package medo.demo.spring.kafka.producer;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import medo.demo.spring.kafka.Message;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public SendResult<Object, Object> syncSend(Long id, String name) throws ExecutionException, InterruptedException {
        Message message = new Message();
        message.setId(id);
        message.setCreateDate(new Date());
        message.setName(name);
        return kafkaTemplate.send(Message.TOPIC, message).get();
    }

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Long id, String name) {
        Message message = new Message();
        message.setId(id);
        message.setCreateDate(new Date());
        message.setName(name);
        return kafkaTemplate.send(Message.TOPIC, message);
    }
}
