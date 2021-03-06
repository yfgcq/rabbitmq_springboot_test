package com.tsl.rabbitmq_springboot_test.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout_email_queue")
public class FanoutEamilConsumer {
    @RabbitHandler
    public void process(String msg) throws Exception {
        System.out.println("邮件消费者获取生产者消息msg:" + msg);
    }
}

