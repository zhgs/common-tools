package com.common.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc:
 * @Author: zhouguangsheng
 * @Date: create by 2020/6/23 17:01
 * @Modify By:
 */
@Service
public class Producter {

    @Resource
    private KafkaTemplate kafkaTemplate;

    public void send(String name, int id) {
        User user = new User();
        user.setName(name);
        user.setAge(18);
        user.setId(id);
        kafkaTemplate.send("user", user.toString());
    }
}
