package medo.demo.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import medo.demo.spring.kafka.Message;

@Component
public class Consumer {

    @KafkaListener(topics = Message.TOPIC, groupId = "medo-learning-group-" + Message.TOPIC)
    public void onMessage(ConsumerRecord<Integer, Message> record) {
        System.out.println(record.value().getId());
    }
}
