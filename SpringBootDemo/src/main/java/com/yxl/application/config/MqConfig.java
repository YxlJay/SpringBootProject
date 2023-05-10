package com.yxl.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 9:27
 **/
@Configuration
public class MqConfig {

    /**
     * 声明交换机
     **/
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("springDirect");
    }

    /**
     *声明队列
     **/
    @Bean
    public Queue queue(){
        return new Queue("springBoot");
    }

    /**
     * 进行绑定
     **/
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("666");
    }
}
