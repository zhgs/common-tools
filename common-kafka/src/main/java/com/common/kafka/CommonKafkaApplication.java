package com.common.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommonKafkaApplication {

    @Autowired
    private Producter producter;

    @PostConstruct
    public void init(){
        for(int i=0;i<100;i++){
            producter.send("afs"+i,i);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CommonKafkaApplication.class, args);
    }

}
