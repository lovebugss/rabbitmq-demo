package com.itrjp.demo.consumer.config;

import com.itrjp.demo.config.Const;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : renjp
 * @date : 2021-03-06 20:11
 **/
@EnableRabbit
@Configuration
public class RabbitMqConfigure {
    @Bean
    public Queue demoQueue() {
        return new Queue(Const.DEMO_QUEUE);
    }

    @Bean
    public TopicExchange demoTopicExchange() {
        return new TopicExchange(Const.DEMO_EXCHANGE);
    }

    @Bean
    Binding demoBinding(Queue demoQueue, TopicExchange demoTopicExchange) {
        return BindingBuilder.bind(demoQueue).to(demoTopicExchange).with(Const.DEMO_RK);
    }

    @Bean
    public Queue demo1Queue() {
        return new Queue(Const.DEMO_QUEUE_1);
    }


    @Bean
    Binding demo1Binding(Queue demo1Queue, TopicExchange demoTopicExchange) {
        return BindingBuilder.bind(demo1Queue).to(demoTopicExchange).with(Const.DEMO_RK_1);
    }
}
