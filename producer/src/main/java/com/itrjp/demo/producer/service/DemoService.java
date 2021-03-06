package com.itrjp.demo.producer.service;

import com.itrjp.demo.config.Const;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : renjp
 * @date : 2021-03-06 21:23
 **/
@Service
public class DemoService {
    private final RabbitTemplate rabbitTemplate;

    public DemoService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMsg(String content) {
        System.out.println("发送消息： " + content);
        rabbitTemplate.convertAndSend(Const.DEMO_EXCHANGE, Const.DEMO_RK, content);
    }

    public void sendMsg1(String content) {
        System.out.println("发送消息： " + content);
        rabbitTemplate.convertAndSend(Const.DEMO_EXCHANGE, Const.DEMO_RK_1, content);
    }
}
