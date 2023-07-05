package com.test.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        String exchange = "fanout_exchange_order";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    @RabbitListener(queues = "wechat.fanout.queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
