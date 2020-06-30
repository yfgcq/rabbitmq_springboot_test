package com.tsl.rabbitmq_springboot_test.controller;

import com.tsl.rabbitmq_springboot_test.producer.FanoutProducer;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProducerController {
    @Autowired
    private FanoutProducer fanoutProducer;

    @Value("${yfgcq.order.exchange}")
    private String orderExchange;

    @Value("${yfgcq.order.queue}")
    private String orderQueue;

    @Value("${yfgcq.order.routingKey}")
    private String orderRoutingKey;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sendFanout")
    public String sendFanout(String queueName) {
        fanoutProducer.send(queueName);
        return "success";
    }

    @RequestMapping("/sendOrderMsg")
    public String sendOrderMsg() {
        amqpTemplate.convertAndSend(orderExchange, orderRoutingKey, "yfgcq", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        });
        //amqpTemplate.convertAndSend(orderExchange, orderRoutingKey, "yfgcq");
        return "success";
    }
}

