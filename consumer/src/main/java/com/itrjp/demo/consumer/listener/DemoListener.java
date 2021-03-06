package com.itrjp.demo.consumer.listener;

import com.itrjp.demo.config.Const;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : renjp
 * @date : 2021-03-06 20:20
 **/
@Component
@RabbitListener(queues = Const.DEMO_QUEUE)
public class DemoListener {

    @RabbitHandler
    public void handler(String content) {
        System.out.println("接受的的内容：" + content);
    }
}
