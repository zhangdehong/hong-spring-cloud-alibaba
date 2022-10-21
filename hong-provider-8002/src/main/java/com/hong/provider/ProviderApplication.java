package com.hong.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  22:07 2022/7/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main (String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
