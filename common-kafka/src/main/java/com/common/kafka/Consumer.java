package com.common.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/6/23 17:09
 * @Modify By:
 */
@Service
public class Consumer {

    @KafkaListener(topics = "user")
    public void consumer(ConsumerRecord consumerRecord){
        Optional<Object> value = Optional.ofNullable(consumerRecord.value());
        if(value.isPresent()){
            System.out.println(value.get().toString());
        }
    }
}
