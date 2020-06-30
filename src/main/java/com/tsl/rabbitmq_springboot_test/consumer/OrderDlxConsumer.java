package com.tsl.rabbitmq_springboot_test.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderDlxConsumer {
    @RabbitListener(queues = "yfgcq_order_dlx_queue")
    public void orderConsumer(String msg) {
        System.out.println("私信队列获取消息:" + msg);
    }
}