package com.atgenghx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/*
*@SpringBootApplication来标注一个主程序类，说明这是一个Spring boot 应用/
*/

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class TestWorld {
    public static void main(String[] args) {
        SpringApplication.run(TestWorld.class,args);
    }
}
