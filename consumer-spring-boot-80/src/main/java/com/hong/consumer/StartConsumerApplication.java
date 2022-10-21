package com.hong.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  15:07 2022/10/4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StartConsumerApplication {

    public static void main (String[] args) {
        SpringApplication.run(StartConsumerApplication.class, args);
    }
}
