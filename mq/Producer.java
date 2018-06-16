package com.bank.credit.gateway.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send() {

        String message = "hello";

        rabbitmqTemplate.convertAndSend(message);

    }
}
