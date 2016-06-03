package com.lsgggg123.springboot.amqp.listener;

import com.lsgggg123.springboot.amqp.dto.MsgDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息格式: {"msg":"123","length":3}
 * Created by liushun on 16/5/23.
 */
@Component
public class MsgListener {
    @RabbitListener(queues = {"Insurance_Queue"},containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(final MsgDto msg) throws Exception {
        System.out.println(msg);
    }
}
