package com.yxl.application.config;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.yxl.application.entity.Admins;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 作者: Jay
 * 功能: Text
 * 时间: 2023/5/10 9:36
 **/
@Component
public class ConsumerMq {
    @RabbitListener(queues = "springBoot")
    @RabbitHandler
    public void getMessage(Channel channel, Message message){


        System.out.println( new String(message.getBody()));
    }
}
