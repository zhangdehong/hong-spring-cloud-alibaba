package com.hong.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import study.hong.config.ribbon.DeptProviderRibbonConfig;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  15:07 2022/10/4
 */
@SpringBootApplication
@EnableDiscoveryClient
// 自定义ribbon配置  如果有多个配置项  可用使用 @RibbonClients注解
@RibbonClient(name="hong.dept.provider",configuration = DeptProviderRibbonConfig.class)
public class StartConsumerApplication {

    public static void main (String[] args) {
        SpringApplication.run(StartConsumerApplication.class, args);
    }
}
