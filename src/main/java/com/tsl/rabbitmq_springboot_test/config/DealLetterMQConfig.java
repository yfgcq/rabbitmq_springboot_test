package com.tsl.rabbitmq_springboot_test.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DealLetterMQConfig {
    @Value("${yfgcq.order.exchange}")
    private String orderExchange;

    @Value("${yfgcq.order.queue}")
    private String orderQueue;

    @Value("${yfgcq.order.routingKey}")
    private String orderRoutingKey;

    @Value("${yfgcq.dlx.exchange}")
    private String dlxExchange;

    @Value("${yfgcq.dlx.queue}")
    private String dlxQueue;

    @Value("${yfgcq.dlx.routingKey}")
    private String dlxRoutingKey;

    //@Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(orderExchange);
    }
    //@Bean
    public Queue orderQueue() {
        Map<String,Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange",dlxExchange);
        arguments.put("x-dead-letter-routing-key",dlxRoutingKey);
        return new Queue(orderQueue,true,false,false,arguments);
        //return new Queue(orderQueue);
    }
    //@Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange(dlxExchange);
    }
    //@Bean
    public Queue dlxQueue() {
        return new Queue(dlxQueue);
    }
    @Bean
    Binding bindingExchangeOrder() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(orderRoutingKey);
    }

    @Bean
    Binding bindingDlxExchangeOrder() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(dlxRoutingKey);
    }
}
